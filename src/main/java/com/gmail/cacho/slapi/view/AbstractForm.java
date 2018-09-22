package com.gmail.cacho.slapi.view;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTabGroup;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenter;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;
import com.gmail.cacho.slbase.logging.L;
import com.gmail.cacho.slbase.view.excepciones.VistaErrorException;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import static com.gmail.cacho.slapi.view.utils.ViewTools.capitalize;


/**
 * Esta clase es la implementación por defecto de la interfase IPresentableForm e
 * implementa un objeto presentable del sistema asociado a un esquema de formulario
 * CRUD para registros asociados a un Entidad particular del Sistema.
 * En cada caso, para cada Entidad del Sistema deseada, se debe heredar de esta clase
 * y clase heredada debe tener la anotación @ViewScope e inyectar (vía la anotación @
 * Inject) el Presenter que corresponda, el cual controlara el comportamiento de este
 * objeto presentable.
 * NOTA: esta clase permite ser utilizada como una vista principal, es decir llamada
 * directamente desde el Menú del sistema, o bien como parte de otro Formulario que la
 * contiene. En el primer caso, el atributo 'padre' debe permanecer null y en el segundo
 * caso debe ser establecido (vía el metodo setPadre()) al Formulario que lo contiene.
 *
 * @param <T> la Entidad del Sistema que se gestionará vía listado dentro de este objeto presentable
 *
 * @author cachorios-jmfragueiro
 * @version 20180204
 */
public abstract class AbstractForm<T extends AbstractEntidad> extends AbstractPresentable<T> implements IPresentableForm<T> {
    private IPresenterForm<T> presenter;
    protected T editItem;
    private Runnable onSaveOK;
    private CustomTabGroup tabGroup;
    private BeanValidationBinder<T> binder;
    private boolean hasChanges, hasValidationErrors;
    private ILayoutInnerForm<T> layout;

    protected AbstractForm(IPresenterForm<T> presenter) {
        super();
        this.presenter = presenter;
        presenter.setPresentable(this);
    }

    private void generarBinder() {
        this.binder = new BeanValidationBinder<>(getEntityType());
    }

    private void generarVista() {
        String titulo = getTitulo();
        if(getTitulo() != null && this.editItem != null && !this.editItem.isNew()){
            titulo += " - " + capitalize(this.editItem.toString());
        }

        layout = generarLayout(this, titulo);
    }

    private void mostrarVentana() {
        layout.getPrimerElementoForm().focus();
        layout.mostrar();
    }

    private void bindearCampos() {
        if (getBinder() != null) {
            layout.bindFormFields(getBinder());
            getBinder().readBean(editItem);
        }
    }

    private void establecerEdicion() {
        setEditableState(getModoVista() != EModoVista.VER);
    }

    protected abstract ILayoutInnerForm<T> generarLayout(AbstractForm<T> padre, String titulo);

    protected void setTabGroup(CustomTabGroup tabGroup) { this.tabGroup = tabGroup; }

    protected abstract Focusable getPrimerElementoForm();

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
    public IPresenter<T> getPresenter() {
        return presenter;
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
        generarBinder();
        setObjetoActivo((T)item);
        generarVista();
        bindearCampos();
        definirComportamientoComponentes();
        actualizarEstadoBotones();
        establecerEstadoInicial();
        establecerEdicion();
        mostrarVentana();
    }

    @Override
    public Component getViewComponent() {
        return (Component)layout;
    }

    @Override
    public void cerrar() {
        if (contieneTabs()) {
            getTabGroup().cerrar();
        }

        editItem = null;
        layout.cerrar();
    }

    @Override
    public boolean hasUnsavedChanges() {
        return hasChanges;
    }

    @Override
    public boolean hasValidationErrors() {
        return hasValidationErrors;
    }

    @Override
    abstract public String getTagVista();

    @Override
    public abstract Class<T> getEntityType();

    @Override
    public BeanValidationBinder<T> getBinder() {
        return binder;
    }

    @Override
    public void setObjetoActivo(T objeto) {
        if (objeto != null) {
            if (objeto.getClass() != getEntityType()) {
                throw new VistaErrorException(C.MSJ_VIW_ERR_NONEWITEM,
                                              C.SYS_CAD_OPENTYPE
                                                      .concat(objeto.getClass().getSimpleName())
                                                      .concat(C.SYS_CAD_REFER)
                                                      .concat(getEntityType().getSimpleName()));
            }

            editItem = objeto;
            actualizarTabs(editItem);
        } else {
            try {
                editItem = getEntityType().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new VistaErrorException(C.MSJ_VIW_ERR_CLASSITEM, e.toString());
            }
        }

        if (presenter != null && getModoVista().equals(EModoVista.NUEVO)) {
            presenter.presetOnAdd(editItem);
        }
    }

    @Override
    public T getObjetoActivo() {
        return editItem;
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
    public boolean esVisualizable(ComponenteVista componente) {
        return true;
    }

    @Override
    public boolean esHabilitable(ComponenteVista componente) {
        return (componente.getModosVista().contains(this.getModoVista())
                && (!componente.conForm() || (hasChanges && !hasValidationErrors))
                && (!componente.conSel() || editItem != null));
    }

    @Override
    public AbstractEntidad getObjetoMasterTab(Class claseTab) {
        return editItem;
    }
}