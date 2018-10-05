package com.gmail.sanfrancisco.view.dtedetalleinsumo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;
import com.gmail.sanfrancisco.serviciosModelo.DteDetalleInsumoService;

import javax.inject.Inject;

public class DteDetalleInsumoListPresenter extends AbstractPresenterList<DteDetalleInsumo, DteDetalleInsumoService> {
    @Inject
    public DteDetalleInsumoListPresenter(DteDetalleInsumoService servicio, FilterablePageableDataProvider<DteDetalleInsumo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}