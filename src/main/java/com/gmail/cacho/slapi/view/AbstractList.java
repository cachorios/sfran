package com.gmail.cacho.slapi.view;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTab;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.*;

import com.gmail.cacho.slapi.view.layouts.DefaultInnerListPolymer;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;
import com.gmail.cacho.slbase.logging.L;
import com.gmail.cacho.slbase.view.excepciones.VistaErrorException;
import com.vaadin.flow.component.Component;

import java.util.Collections;
import java.util.List;

/**
 * Esta clase es la implementación por defecto de la interfase IPresentableList e
 * implementa un objeto presentable del sistema asociado a un esquema de listado de
 * registros asociados a un Entidad particular del Sistema.
 * En cada caso, para cada Entidad del Sistema deseada, se debe heredar de esta clase
 * y clase heredada debe tener la anotación @ViewScope e inyectar (vía la anotación @
 * Inject) el Presenter que corresponda, el cual controlara el comportamiento de este
 * objeto presentable.
 * NOTA: esta clase permite ser utilizada como una vista principal, es decir llamada
 * directamente desde el Menú del sistema, o bien dentro del un tab como parte de un
 * Formulario (CRUD o no ) que la contiene. En el primer caso, el atributo 'padre' debe
 * permanecer null y en el segundo caso debe ser establecido (vía el metodo setPadre())
 * al Formulario que lo contiene.
 *
 * @param <T> la Entidad del Sistema que se gestionará vía listado dentro de este objeto presentable
 * @author cachorios-jmfragueiro
 * @version 20180204
 */

public abstract class AbstractList<T extends AbstractEntidad> extends AbstractPresentable<T> implements IPresentableList<T> {
    private IPresenterList<T> presenter;
    private IPresentableForm<T> form;
    private IVisualizableReadOnly<T> preview;
    private ILayoutInnerList<T> layout;
    private List<ColumnList> listaCols;
    private T registroSelect;
    private CustomTab tabpadre;

    protected AbstractList(IPresenterList<T> presenter) {
        super();
        this.presenter = presenter;
        presenter.setPresentable(this);
    }

    protected void generarVista() {
        layout = generarLayout(this, ((getPadre() != null) ? null : getTitulo()));
    }

    private void mostrarVentana() {
        habilitarBotones();
    }

    protected ILayoutInnerList<T> generarLayout(AbstractList<T> padre, String titulo) {
        return new DefaultInnerListPolymer<>(padre, getTitulo());

    }

    protected void setListaCols(List<ColumnList> listaCols) {
        this.listaCols = listaCols;
    }

    @Override
    public IPresentableForm<T> getForm() {
        return form;
    }

    @Override
    public void setForm(IPresentableForm<T> form) {
        if (form != null) {
            L.info(C.MSG_ACC_SETFORMCRUD, form.getClass().getSimpleName().concat(C.SYS_CAD_REFER).concat(this.getClass().getSimpleName()));
            this.form = form;
            form.setPadre(this);
        } else {
            throw new VistaErrorException(C.MSJ_ERR_NOFORM);
        }
    }

    @Override
    public void actualizar(Object parametro) {
        refrescarLista(parametro);
    }

    @Override
    public IVisualizableReadOnly<T> getPreview() {
        return preview;
    }

    @Override
    public void setPreview(IVisualizableReadOnly<T> preview) {
        if (preview != null) {
            L.info(C.MSG_ACC_SETPREVIEW,
                    preview.getClass().getSimpleName().concat(C.SYS_CAD_REFER).concat(this.getClass().getSimpleName()));
            this.preview = preview;
            preview.setPadre(this);
        } else {
            throw new VistaErrorException(C.MSJ_ERR_NOPREVIEW);
        }
    }

    @Override
    public void iniciar(EModoVista modoVista, AbstractEntidad item) {
        L.info(C.MSG_ACC_INITVIEW, this.getClass().getSimpleName().concat(C.SYS_CAD_OPENTYPE)
                .concat(((modoVista != null) ? modoVista.toString() : C.SYS_CAD_TXTNULL.concat(C.SYS_CAD_REFER)
                        .concat(EModoVista.VER
                                .toString())))
                .concat(C.SYS_CAD_LOGSEP).concat(((item != null) ? item.toString() : C.SYS_CAD_TXTNULL))
                .concat(C.SYS_CAD_CLOSETPE));

        setModoVista(modoVista);
        presenter.setItemPadre(item);
        generarVista();
        definirComportamientoComponentes();
        actualizarEstadoBotones();
        establecerEstadoInicial();
        mostrarVentana();
    }

    @Override
    public Component getViewComponent() {
        return layout.getLayout();
    }

    @Override
    public void cerrar() {
        registroSelect = null;
        layout.getGrilla().deselectAll();
    }

    @Override
    public IPresenter<T> getPresenter() {
        return presenter;
    }


    @Override
    public void setObjetoActivo(T objeto) {
        registroSelect = objeto;
        if (preview != null) {
            preview.actualizar(registroSelect);
        }
        presenter.alActualizarSeleccion(Collections.singletonList(registroSelect));
        habilitarBotones();
    }

    @Override
    public T getObjetoActivo() {
        return registroSelect;
    }

    @Override
    public List<ColumnList> getListaCols() {
        return listaCols;
    }

    @Override
    public void refrescarLista(Object parametro) {
        registroSelect = null;
        presenter.listList(parametro);
        habilitarBotones();
    }

    @Override
    public boolean esVisualizable(ComponenteVista componente) {
        return (!componente.conForm() || (form != null));
    }

    @Override
    public boolean esHabilitable(ComponenteVista componente) {
        return (componente.getModosVista().contains(this.getModoVista()) && (!componente.conSel() || registroSelect != null));
    }

    @Override
    public void setVisible(boolean visible) {
        getViewComponent().setVisible(visible);
    }

    @Override
    public boolean isVisible() {
        return getViewComponent().isVisible();
    }
}