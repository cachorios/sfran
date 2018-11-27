package com.gmail.sanfrancisco.view.graseriadetalleinsumo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleInsumo;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaDetalleInsumoService;

import javax.inject.Inject;

public class GraseriaDetalleInsumoListPresenter extends AbstractPresenterList<GraseriaDetalleInsumo, GraseriaDetalleInsumoService> {
    @Inject
    public GraseriaDetalleInsumoListPresenter(GraseriaDetalleInsumoService servicio, FilterablePageableDataProvider<GraseriaDetalleInsumo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
