package com.gmail.cacho.slapi.view;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTab;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTabGroup;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerPanel;
import com.gmail.cacho.slapi.view.interfaces.IManager;
import com.gmail.cacho.slapi.view.interfaces.IManagerPanel;
import com.gmail.cacho.slapi.view.interfaces.IVisualizablePanel;
import com.gmail.cacho.slbase.logging.L;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;

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
public abstract class AbstractPanel extends AbstractPresentable implements IVisualizablePanel {
    private IManager manager;
    private Runnable onSaveOK;
    private CustomTabGroup tabGroup;
    private ILayoutInnerPanel layout;
    private CustomTab tabPadre;

    protected AbstractPanel(IManagerPanel manager) {
        super();
        this.manager = manager;
        manager.setGestionable(this);
    }

    private void generarVista() {
        layout = generarLayout(this, ((getPadre() != null) ? null : getTitulo()));
    }

    private void mostrarVentana() {
        this.layout.getPrimerElementoForm().focus();
        habilitarBotones();
    }

    protected abstract ILayoutInnerPanel generarLayout(AbstractPanel padre, String titulo);

    protected void setTabGroup(CustomTabGroup tabGroup) { this.tabGroup = tabGroup; }

    protected abstract Focusable getPrimerElementoForm();

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
    public void setTabPadre(CustomTab tab) {
        tabPadre = tab;
    }

    @Override
    public CustomTab getTabPadre() {
        return tabPadre;
    }
}