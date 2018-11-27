package com.gmail.sanfrancisco.view.graseriadetalleimpuesto;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleImpuesto;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaDetalleImpuestoService;

import javax.inject.Inject;

public class GraseriaDetalleImpuestoFormPresenter extends AbstractPresenterForm<GraseriaDetalleImpuesto, GraseriaDetalleImpuestoService> {
    @Inject
    public GraseriaDetalleImpuestoFormPresenter(GraseriaDetalleImpuestoService servicio) { super(servicio); }
}