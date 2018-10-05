package com.gmail.sanfrancisco.view.dtedetalleinsumo;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;
import com.gmail.sanfrancisco.serviciosModelo.DteDetalleInsumoService;

import javax.inject.Inject;

public class DteDetalleInsumoFormPresenter extends AbstractPresenterForm<DteDetalleInsumo, DteDetalleInsumoService> {
    @Inject
    public DteDetalleInsumoFormPresenter(DteDetalleInsumoService servicio) {
        super(servicio);
    }
}
