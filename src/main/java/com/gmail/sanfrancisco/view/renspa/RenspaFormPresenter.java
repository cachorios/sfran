package com.gmail.sanfrancisco.view.renspa;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.gmail.sanfrancisco.serviciosModelo.RenspaService;

import javax.inject.Inject;

public class RenspaFormPresenter extends AbstractPresenterForm<Renspa, RenspaService> {
    @Inject
    public RenspaFormPresenter(RenspaService servicio) { super(servicio); }
}
