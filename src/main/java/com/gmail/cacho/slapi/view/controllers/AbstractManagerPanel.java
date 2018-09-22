package com.gmail.cacho.slapi.view.controllers;


import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.IManagerPanel;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.cacho.slbase.logging.L;
import com.gmail.cacho.slbase.persist.excepciones.UserFriendlyDataException;

import java.util.Optional;

public abstract class AbstractManagerPanel extends AbstractManager implements IManagerPanel {

    public AbstractManagerPanel() {
    }

    private boolean esValidaCargaDeDatos() {
        return isModelOKForSave();
    }

    protected boolean procesarGuardado() {
        if (esValidaCargaDeDatos()) {
            try {
                ///////////////////////////////////////////////////////////////////
                // Procesa el guardado
                ///////////////////////////////////////////////////////////////////
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.INFO, C.WIN_TIT_SAVEREG, C.CRUD_MSG_BOXOK);
                ///////////////////////////////////////////////////////////////////

                ///////////////////////////////////////////////////////////////////
                // Ejecuta el codigo de SavedOK
                ///////////////////////////////////////////////////////////////////
                (Optional.of(((AbstractForm) getGestionable()).getExecutableOnSaveOK())).ifPresent(Runnable::run);
                ///////////////////////////////////////////////////////////////////


                return true;
            } catch (UserFriendlyDataException e) {
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_DB_VERIFYFIELD, e.getMessage());
                L.info(C.MSJ_ERR_DB_VERIFYFIELD, e.getMessage());
            } catch (Exception e) {
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_DB_ATSAVEDATA, e.getMessage());
                L.info(C.MSJ_ERR_DB_ATSAVEDATA, e.getMessage());
            }
        }


        return false;
    }

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
                        getGestionable().cerrar();
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
        getGestionable().cerrar();
    }
}
