package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.gmail.sanfrancisco.serviciosModelo.ComisionistaService;

import javax.inject.Inject;

public class ComisionistaFormPresenter extends AbstractPresenterForm<Comisionista, ComisionistaService> {
    @Inject
    public ComisionistaFormPresenter(ComisionistaService servicio) { super(servicio); }
}
