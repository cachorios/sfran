package com.gmail.sanfrancisco.view.dtedetallecategoria;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.gmail.sanfrancisco.serviciosModelo.DteDetalleCategoriaService;

import javax.inject.Inject;

public class DteDetalleCategoriaFormPresenter extends AbstractPresenterForm<DteDetalleCategoria, DteDetalleCategoriaService> {
    @Inject
    public DteDetalleCategoriaFormPresenter(DteDetalleCategoriaService servicio) {
        super(servicio);
    }
}