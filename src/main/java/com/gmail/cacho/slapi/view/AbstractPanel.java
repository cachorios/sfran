package com.gmail.cacho.slapi.view;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTab;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTabGroup;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.*;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;
import com.gmail.cacho.slbase.logging.L;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es la implementación por defecto de la interfase IVisuatablePanel e
 * implementa un objeto visuatable del sistema en un esquema de 'panel de trabajo'.
 * En cada caso se debe heredar de esta clase y la clase heredada deberá tener la
 * anotación @ViewScope e inyectar (vía la anotación @Inject) el Manager que le
 * corresponda, el cual controlara el comportamiento de este objeto visuatable.
 * NOTA: esta clase permite ser utilizada como una vista principal, es decir llamada
 * directamente desde el Menú del sistema, o bien como parte de otro Formulario que la
 * contiene. En el primer caso, el atributo 'padre' debe permanecer null y en el segundo
 * caso debe ser establecido (vía el metodo setPadre()) al Formulario que lo contiene.
 *
 * @author cachorios-jmfragueiro
 * @version 20180204
 */
public abstract class AbstractPanel implements IManageablePanel {
    private IVisualizable padre;
    private List<ComponenteVista> componentesVista;
    private EModoVista modoVista;
    private IManager manager;
    private Runnable onSaveOK;
    private ILayoutInnerPanel layout;
    private CustomTabGroup tabGroup;
    private CustomTab tabpadre;

    protected AbstractPanel(IManagerPanel manager) {
        componentesVista = new ArrayList<>();
        this.manager = manager;
        manager.setGestionable(this);
    }

    protected void setModoVista(EModoVista modoVista) {
        this.modoVista = (modoVista == null) ? EModoVista.VER : modoVista;
    }

    private void generarVista() {
        layout = generarLayout(this, ((getPadre() != null) ? null : getTitulo()));
    }

    @Override
    public void registrarComponenteVista(ComponenteVista componente) {
        componentesVista.add(componente);
    }

    @Override
    public List<ComponenteVista> getComponentesVista() {
        return componentesVista;
    }

    private void mostrarVentana() {
        this.layout.getPrimerElementoForm().focus();
        habilitarBotones();
    }

    protected abstract ILayoutInnerPanel generarLayout(AbstractPanel padre, String titulo);

    protected void setTabGroup(CustomTabGroup tabGroup) { this.tabGroup = tabGroup; }

    protected abstract Focusable getPrimerElementoForm();

    protected void definirComportamientoComponentes() {
        componentesVista.forEach(b -> b.getComponente().addClickListener(b.getCl()));
    }

    protected void actualizarEstadoBotones() {
        visualizarBotones();
        habilitarBotones();
    }

    protected void visualizarBotones() {
        // primero verificar por permisos del usuario
        getManager().aplicarPermisos();

        // finalmente verifica por si existe un panel asociado
        componentesVista.stream()
                .filter(bv -> bv.getComponente().isVisible())
                .forEach(bv -> bv.getComponente().setVisible(esVisualizable(bv)));
    }

    protected void habilitarBotones() {
        componentesVista.stream()
                .filter(bv -> bv.getComponente().isVisible())
                .forEach(bv -> bv.getComponente().setEnabled(esHabilitable(bv)));
    }

    @Override
    public boolean hasUnsavedChanges() {
        return false;
    }

    @Override
    public boolean hasValidationErrors() {
        return false;
    }

    @Override
    public AbstractEntidad getObjetoMasterTab(Class claseTab) {
        return null;
    }

    @Override
    public boolean contieneTabs() {
        return (tabGroup != null && tabGroup.size() > 0);
    }

    @Override
    public CustomTabGroup getTabGroup() { return tabGroup; }

    @Override
    public void actualizarTabs(Object item) {
        if (contieneTabs()) {
            tabGroup.actualizarTabs(item);
        }
    }

    @Override
    public IManager getManager() {
        return manager;
    }

    @Override
    public void iniciar(EModoVista modoVista, AbstractEntidad item) {
        L.info(C.MSG_ACC_INITVIEW,
                this.getClass().getSimpleName()
                        .concat(C.SYS_CAD_OPENTYPE)
                        .concat(((modoVista != null)
                                ? modoVista.toString()
                                : C.SYS_CAD_TXTNULL.concat(C.SYS_CAD_REFER).concat(EModoVista.VER.toString())))
                        .concat(C.SYS_CAD_LOGSEP)
                        .concat(((item != null)
                                ? item.toString()
                                : C.SYS_CAD_TXTNULL))
                        .concat(C.SYS_CAD_CLOSETPE));

        setModoVista(modoVista);
        generarVista();
        definirComportamientoComponentes();
        actualizarEstadoBotones();
        establecerEstadoInicial();
        mostrarVentana();
    }

    @Override
    public String getTitulo() {
        return C.WIN_TIT_GENERICO;
    }

    @Override
    public Component getViewComponent() {
        return layout.getLayout();
    }

    @Override
    public void cerrar() {
        if (contieneTabs()) {
            getTabGroup().cerrar();
        }
    }

    @Override
    public void setEditableState(boolean enable) {
        layout.setEditableState(enable);
    }

    @Override
    public void setExecutableOnSaveOK(Runnable runnable) {
        this.onSaveOK = runnable;
    }

    @Override
    public Runnable getExecutableOnSaveOK() {
        return this.onSaveOK;
    }

    @Override
    public void establecerEstadoInicial() {

    }

    @Override
    public void actualizar(Object parametro) {

    }

    @Override
    public boolean esVisualizable(ComponenteVista componente) {
        return true;
    }

    @Override
    public EModoVista getModoVista() {
        return modoVista;
    }

    @Override
    public boolean esHabilitable(ComponenteVista componente) {
        return (componente.getModosVista().contains(this.getModoVista()));
    }

    @Override
    public void setTabpadre(CustomTab tab) {
        tabpadre = tab;
    }

    @Override
    public CustomTab getTabpadre() {
        return tabpadre;
    }

    @Override
    public void setVisible(boolean visible) {
        getViewComponent().setVisible(visible);
    }

    @Override
    public boolean isVisible() {
        return getViewComponent().isVisible();
    }

    @Override
    public IVisualizable getPadre() {
        return padre;
    }

    @Override
    public void setPadre(IVisualizable padre) {
        this.padre = padre;
    }
}