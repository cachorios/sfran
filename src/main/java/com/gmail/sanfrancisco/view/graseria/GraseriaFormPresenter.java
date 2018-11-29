package com.gmail.sanfrancisco.view.graseria;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Graseria;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaService;

import javax.inject.Inject;

public class GraseriaFormPresenter extends AbstractPresenterForm<Graseria, GraseriaService> {
    @Inject
    public GraseriaFormPresenter(GraseriaService servicio) { super(servicio); }
}
