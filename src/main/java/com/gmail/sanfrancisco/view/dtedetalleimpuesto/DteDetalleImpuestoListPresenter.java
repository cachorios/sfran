package com.gmail.sanfrancisco.view.dtedetalleimpuesto;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.DteDetalleImpuesto;
import com.gmail.sanfrancisco.serviciosModelo.DteDetalleImpuestoService;

import javax.inject.Inject;

public class DteDetalleImpuestoListPresenter extends AbstractPresenterList<DteDetalleImpuesto, DteDetalleImpuestoService> {
    @Inject
    public DteDetalleImpuestoListPresenter(DteDetalleImpuestoService servicio, FilterablePageableDataProvider<DteDetalleImpuesto, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}