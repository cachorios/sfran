package com.gmail.sanfrancisco.view.licencia;

import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.cacho.slbase.logging.L;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.gmail.sanfrancisco.serviciosModelo.ConductorService;
import com.gmail.sanfrancisco.serviciosModelo.LicenciaService;

import javax.inject.Inject;
import java.util.Optional;

public class LicenciaFormPresenter extends AbstractPresenterForm<Licencia, LicenciaService> {
    @Inject
    public LicenciaFormPresenter(LicenciaService servicio) {
        super(servicio);
    }

    @Override
    protected boolean procesarGuardado() {
        if (esValidaCargaDeDatos()) {

            Licencia item = getPresentable().getObjetoActivo();
            try {
                ///////////////////////////////////////////////////////////////////
                // Procesa el guardado
                ///////////////////////////////////////////////////////////////////
                //DteDetalleCategoria item2 = servicio.save(item);

                getPresentable().setObjetoActivo(item);
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.INFO, C.WIN_TIT_SAVEREG, C.CRUD_MSG_BOXOK);
                ///////////////////////////////////////////////////////////////////

                ///////////////////////////////////////////////////////////////////
                // Ejecuta el codigo de SavedOK
                ///////////////////////////////////////////////////////////////////
                (Optional.of(((AbstractForm) getPresentable()).getExecutableOnSaveOK())).ifPresent(Runnable::run);
                ///////////////////////////////////////////////////////////////////

                return true;

            } catch (Exception e) {
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_DB_ATSAVEDATA, "Se ha producido un problema al guardar los datos. Por favor verifique los campos"  );
                L.info(C.MSJ_ERR_DB_ATSAVEDATA, "Se ha producido un problema al guardar los datos. Por favor verifique los campos  " + item.getClass().getName()+" | " + e.getLocalizedMessage());
            }

        }

        return false;
    }
}
