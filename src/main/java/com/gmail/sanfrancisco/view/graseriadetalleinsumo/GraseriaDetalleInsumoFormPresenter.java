package com.gmail.sanfrancisco.view.graseriadetalleinsumo;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleInsumo;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaDetalleInsumoService;

import javax.inject.Inject;

public class GraseriaDetalleInsumoFormPresenter extends AbstractPresenterForm<GraseriaDetalleInsumo, GraseriaDetalleInsumoService> {
    @Inject
    public GraseriaDetalleInsumoFormPresenter(GraseriaDetalleInsumoService servicio) { super(servicio); }
}
