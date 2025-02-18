package com.gmail.sanfrancisco.view.dtedetallecategoria;

import com.gmail.cacho.backend.jpa.PersistenceExceptionUtil;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.cacho.slbase.logging.L;
import com.gmail.cacho.slbase.persist.excepciones.UserFriendlyDataException;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.gmail.sanfrancisco.serviciosModelo.DteDetalleCategoriaService;

import javax.inject.Inject;
import java.util.Optional;

public class DteDetalleCategoriaFormPresenter extends AbstractPresenterForm<DteDetalleCategoria, DteDetalleCategoriaService> {
    @Inject
    public DteDetalleCategoriaFormPresenter(DteDetalleCategoriaService servicio) {
        super(servicio);
    }

    @Override
    protected boolean procesarGuardado() {
        if (esValidaCargaDeDatos()) {

            DteDetalleCategoria item = getPresentable().getObjetoActivo();
            try {
                ///////////////////////////////////////////////////////////////////
                // Procesa el guardado
                ///////////////////////////////////////////////////////////////////
                //DteDetalleCategoria item2 = servicio.save(item);

                getPresentable().setObjetoActivo(item);
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.INFO, C.WIN_TIT_SAVEREG, C.CRUD_MSG_BOXOK);

                // Ejecuta el codigo de SavedOK
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



    @Override
    public void formSaveAndAdd() {
        Sistema.getSistema().mostrarBoxConsultaSiNo(
                C.WIN_TIT_SAVEREG,
                C.CRUD_MSG_BOXSAVE,
                C.CRUD_MSG_GUARDAR,
                C.CRUD_MSG_CANCELAR,
                () -> {
                    DteDetalleCategoria reg = getPresentable().getObjetoActivo();
                    if (procesarGuardado()) {
                        getPresentable().cerrar();
                        DteDetalleCategoria nuevo = new DteDetalleCategoria();
                        ((UnoaMuchoGrid)(getPresentable().getPadre())).setObjetoActivo(nuevo);
                        nuevo.setProductor(reg.getProductor());
                        nuevo.setRenspa(reg.getRenspa());
                        getPresentable().iniciar(EModoVista.NUEVO, nuevo);
                    }
                });
    }

}