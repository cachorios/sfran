package com.gmail.sanfrancisco.view.graseriadetalleimpuesto;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleImpuesto;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaDetalleImpuestoService;

import javax.inject.Inject;

public class GraseriaDetalleImpuestoListPresenter extends AbstractPresenterList<GraseriaDetalleImpuesto, GraseriaDetalleImpuestoService> {
    @Inject
    public GraseriaDetalleImpuestoListPresenter(GraseriaDetalleImpuestoService servicio, FilterablePageableDataProvider<GraseriaDetalleImpuesto, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}