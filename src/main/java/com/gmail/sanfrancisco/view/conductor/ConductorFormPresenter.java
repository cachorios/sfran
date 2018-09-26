package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.gmail.sanfrancisco.serviciosModelo.ConductorService;

import javax.inject.Inject;

public class ConductorFormPresenter extends AbstractPresenterForm<Conductor, ConductorService> {
    @Inject
    public ConductorFormPresenter(ConductorService servicio) {
        super(servicio);
    }
}
