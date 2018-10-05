package com.gmail.cacho.slapi.view.controllers;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.jpa.PersistenceExceptionUtil;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.*;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.cacho.slbase.persist.excepciones.PersistErrorException;

import java.util.List;

public abstract class AbstractPresenterList<T extends AbstractEntidad, S extends ServicioModelo<T>>
        extends AbstractPresenter<T> implements IPresenterList<T> {
    protected String filtro;
    protected final S servicio;
    private FilterablePageableDataProvider<T, Long, String> dataProvider;

    public AbstractPresenterList(S servicio, FilterablePageableDataProvider<T, Long, String> dataProvider) {
        super();
        this.servicio = servicio;
        this.dataProvider = dataProvider;
    }

    private void abrirForm(EModoVista modo, AbstractEntidad item) {
        IPresentableForm form = ((IPresentableList<T>) getPresentable()).getForm();
        form.setExecutableOnSaveOK(this::onFormSaveOK);
        form.iniciar(modo, item);
    }

    private void aplicarBorrar() {
       T objeto = getPresentable().getObjetoActivo();
       if (objeto != null && !objeto.isNew()) {
           try {
               servicio.delete(objeto);
               listList(filtro);
           } catch (Exception ex) {
               String msj = PersistenceExceptionUtil.verifyAndGenMessagePersistException(ex);
               Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_DB_EDITFIELD,
                                                   (!msj.isEmpty() ? msj : ex.getMessage()));
           }
       }
    }

    private void aplicarQuitarDeLaLista(AbstractEntidad objPadre) {
        if (objPadre != null) {
            T objeto = getPresentable().getObjetoActivo();
            if (objeto != null && !objeto.isNew()) {
                try {
                    quitarDeLaLista(objPadre, objeto);
                } catch (Exception ex) {
                    String msj = PersistenceExceptionUtil.verifyAndGenMessagePersistException(ex);
                    Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_DB_EDITFIELD, (!msj.isEmpty() ? msj : ex.getMessage()));
                }
            }
        }

        dataProvider.refreshAll();
    }

    private void onFormSaveOK() {
        AbstractForm<T> form = (AbstractForm<T>) ((IPresentableList<T>) getPresentable()).getForm();
        if (form.getModoVista().equals(EModoVista.NUEVO)) {
            getDataProvider().refreshAll();
        } else {
            getDataProvider().refreshItem(form.getObjetoActivo());
        }
    }

    protected void quitarDeLaLista(AbstractEntidad objPadre, T objeto) throws PersistErrorException {
        Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_FCNOTPREENT, null);
    }

    @Override
    public FilterablePageableDataProvider<T, Long, String> getDataProvider() {
        return dataProvider;
    }

    @Override
    public void setItemPadre(Object item) {
        dataProvider.setPadre(item);
    }

    @Override
    public Object getItemPadre() {
        return dataProvider.getPadre();
    }

    @Override
    public long getCantidadRegActual() {
        return dataProvider.getCantidadRegActual();
    }

    @Override
    public long getCantidadRegTotal() {
        return dataProvider.getCantidadRegTotal();
    }

    @Override
    public void alActualizarSeleccion(List<T> seleccion) { }

    @Override
    public void listList(Object parametro) {
        dataProvider.setFiltro((filtro = parametro.toString()));
    }

    @Override
    public void listView() {
        IPresentableList<T> vista = ((IPresentableList<T>) getPresentable());
        abrirForm(EModoVista.VER, vista.getObjetoActivo());
    }

    @Override
    public void listAdd() {
        IVisualizable form = getPresentable().getPadre();
        if (form != null && form instanceof IPresentableForm && ((IPresentableForm) form).hasUnsavedChanges()) {
            ((IPresenterForm) ((IPresentableForm) form)
                    .getPresenter())
                    .formSaveAndContinue(() -> abrirForm(EModoVista.NUEVO, null));
        } else {
            abrirForm(EModoVista.NUEVO, null);
        }
    }

    @Override
    public void listEdit() {
        IVisualizable form = getPresentable().getPadre();
        if (form != null && form instanceof IPresentableForm && ((IPresentableForm) form).hasUnsavedChanges()) {
            ((IPresenterForm) ((IPresentableForm) form).getPresenter())
                    .formSaveAndContinue(() -> abrirForm(EModoVista.EDITAR, getPresentable().getObjetoActivo()));
        } else {
            abrirForm(EModoVista.EDITAR, getPresentable().getObjetoActivo());
        }
    }

    @Override
    public void listRemove() {
        IVisualizable form = getPresentable().getPadre();
        if (form != null && form instanceof IPresentableForm) {
            if (((IPresentableForm) form).hasUnsavedChanges()) {
                ((IPresenterForm) ((IPresentableForm) form).getPresenter()).formSaveAndContinue(() ->
                        Sistema.getSistema()
                             .mostrarBoxConsultaSiNo(C.WIN_TIT_QUITREG,
                                                     C.CRUD_MSG_BOXQUITL,
                                                     C.CRUD_MSG_QUITAR,
                                                     C.CRUD_MSG_CANCELAR,
                                                     () -> aplicarQuitarDeLaLista(((IPresentableForm) form).getObjetoActivo())));
            } else {
                Sistema.getSistema()
                       .mostrarBoxConsultaSiNo(C.WIN_TIT_QUITREG,
                                               C.CRUD_MSG_BOXQUITL,
                                               C.CRUD_MSG_QUITAR,
                                               C.CRUD_MSG_CANCELAR,
                                               () -> aplicarQuitarDeLaLista(((IPresentableForm) form).getObjetoActivo()));
            }
        } else {
            Sistema.getSistema()
                   .mostrarBoxConsultaSiNo(C.WIN_TIT_DELREG,
                                           C.CRUD_MSG_BOXDEL,
                                           C.CRUD_MSG_BORRAR,
                                           C.CRUD_MSG_CANCELAR,
                                           this::aplicarBorrar);

        }
    }
}