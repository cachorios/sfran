package com.gmail.cacho.slapi.view.controllers;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.*;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.cacho.slbase.logging.L;
import com.gmail.cacho.slbase.persist.excepciones.UserFriendlyDataException;
import com.gmail.cacho.slbase.view.excepciones.VistaErrorException;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.binder.ValidationResult;

import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractPresenterForm<T extends AbstractEntidad, S extends ServicioModelo<T>> extends AbstractPresenter<T> implements IPresenterForm<T> {
    protected final S servicio;

    public AbstractPresenterForm(S servicio) {
        this.servicio = servicio;
    }

    protected boolean esValidaCargaDeDatos() {
        AbstractForm<T> form = ((AbstractForm<T>) getPresentable());
        if (form == null) {
            throw new VistaErrorException(C.MSJ_ERR_NOFORM, this.getClass().getSimpleName()
                                                                .concat(C.SYS_CAD_REFER)
                                                                .concat("IPresentableForm"));
        }

        BeanValidationBinder<T> binder = form.getBinder();
        T item = form.getObjetoActivo();

        try {
            // La llamada a validate () solo es necesaria para garantizar que el
            // indicador de error se muestre correctamente para el campo con error

            binder.validate();
            binder.writeBean(item);

        } catch (ValidationException e) {
            String mensaje;

            if (!e.getFieldValidationErrors().isEmpty()) {
                // Field level error
                mensaje = e.getFieldValidationErrors().stream()
                           .map(n -> n.getMessage().toString())
                           .collect(Collectors.joining(Constantes.SYS_CAD_CRLF));
                form.focusField(e.getFieldValidationErrors().get(0).getField());
            } else {
                // Bean validation error
                mensaje = e.getBeanValidationErrors().stream()
                           .map(ValidationResult::getErrorMessage)
                           .collect(Collectors.joining(Constantes.SYS_CAD_CRLF));
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_DB_VERIFYFIELD, mensaje);
            }

            L.info(C.MSJ_ERR_DB_VERIFYFIELD, item.getClass().getName().concat(C.SYS_CAD_LOGSEP).concat(mensaje));
            return false;
        }

        return isModelOKForSave();
    }

    protected boolean procesarGuardado() {
        if (esValidaCargaDeDatos()) {
            T item = getPresentable().getObjetoActivo();
            try {
                ///////////////////////////////////////////////////////////////////
                // Procesa el guardado
                ///////////////////////////////////////////////////////////////////
                ////Todo: persist
                //// T item2 = servicio.persist(item);
                ////getPresentable().setObjetoActivo(item2);
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.INFO, C.WIN_TIT_SAVEREG, C.CRUD_MSG_BOXOK);
                ///////////////////////////////////////////////////////////////////

                ///////////////////////////////////////////////////////////////////
                // Ejecuta el codigo de SavedOK
                ///////////////////////////////////////////////////////////////////
                (Optional.of(((AbstractForm) getPresentable()).getExecutableOnSaveOK())).ifPresent(Runnable::run);
                ///////////////////////////////////////////////////////////////////

                return true;
            } catch (UserFriendlyDataException e) {
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_DB_VERIFYFIELD, e.getMessage());
                L.info(C.MSJ_ERR_DB_VERIFYFIELD, item.getClass().getName().concat(C.SYS_CAD_LOGSEP).concat(e.getMessage()));
            } catch (Exception e) {
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_DB_ATSAVEDATA, e.getMessage());
                L.info(C.MSJ_ERR_DB_ATSAVEDATA, item.getClass().getName().concat(C.SYS_CAD_LOGSEP).concat(e.getMessage()));
            }
        }

        return false;
    }

    protected Object getItemMasterForAdd() {
        IPresentable padre = (IPresentable)getPresentable().getPadre();
        if (padre != null) {
            IPresenter pp = padre.getPresenter();
            if (pp != null) {
                return (pp instanceof IPresenterList)
                            ? ((IPresenterList) pp).getItemPadre()
                            : (pp instanceof IPresenterForm)
                                  ? pp.getPresentable().getObjetoActivo()
                                  : null;
            }
        }

        return null;
    }

    @Override
    public void presetOnAdd(T itemToAdd) { }

    @Override
    public boolean isModelOKForSave() {
        return true;
    }

    @Override
    public void formSave() {
        Sistema.getSistema().mostrarBoxConsultaSiNo(
                C.WIN_TIT_SAVEREG,
                C.CRUD_MSG_BOXSAVE,
                C.CRUD_MSG_GUARDAR,
                C.CRUD_MSG_CANCELAR,
                () -> {
                    if (procesarGuardado()) {
                        getPresentable().cerrar();
                    }
                });
    }

    @Override
    public void formSaveAndAdd() {
        Sistema.getSistema().mostrarBoxConsultaSiNo(
                C.WIN_TIT_SAVEREG,
                C.CRUD_MSG_BOXSAVE,
                C.CRUD_MSG_GUARDAR,
                C.CRUD_MSG_CANCELAR,
                () -> {
                    if (procesarGuardado()) {
                        getPresentable().cerrar();
                        getPresentable().iniciar(EModoVista.NUEVO, null);
                    }
                });
    }

    @Override
    public void formSaveAndContinue(Runnable onOK) {
        Sistema.getSistema().mostrarBoxConsultaSiNo(
                C.WIN_TIT_SAVEREGPPAL,
                C.CRUD_MSG_BOXSAVEPPAL,
                C.CRUD_MSG_GUARCONT,
                C.CRUD_MSG_CANCELAR,
                () -> {
                    if (procesarGuardado()) {
                        onOK.run();
                    }
                });
    }

    @Override
    public void formClose() {
        if (((IPresentableForm<T>) getPresentable()).hasUnsavedChanges()) {
            Sistema.getSistema().mostrarBoxConsultaSiNo(
                    C.WIN_TIT_DESCARTREG,
                    C.CRUD_MSG_BOXCANCEL,
                    C.CRUD_MSG_DESCARTAR,
                    C.CRUD_MSG_CANCELAR,
                    () ->  getPresentable().cerrar());
        } else {
            getPresentable().cerrar();
        }
    }
}
