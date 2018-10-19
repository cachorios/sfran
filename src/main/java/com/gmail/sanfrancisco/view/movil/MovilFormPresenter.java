package com.gmail.sanfrancisco.view.movil;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.gmail.sanfrancisco.serviciosModelo.MovilService;

import javax.inject.Inject;

public class MovilFormPresenter extends AbstractPresenterForm<Vehiculo, MovilService> {
    @Inject
    public MovilFormPresenter(MovilService servicio) { super(servicio); }
}
