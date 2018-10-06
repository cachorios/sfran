package com.gmail.sanfrancisco.view.dtedetalleimpuesto;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.DteDetalleImpuesto;
import com.gmail.sanfrancisco.serviciosModelo.DteDetalleImpuestoService;

import javax.inject.Inject;

public class DteDetalleImpuestoFormPresenter extends AbstractPresenterForm<DteDetalleImpuesto, DteDetalleImpuestoService> {
    @Inject
    public DteDetalleImpuestoFormPresenter(DteDetalleImpuestoService servicio) {
        super(servicio);
    }
}