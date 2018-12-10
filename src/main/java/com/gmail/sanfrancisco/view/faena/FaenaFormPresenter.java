package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Faena;
import com.gmail.sanfrancisco.serviciosModelo.FaenaService;

import javax.inject.Inject;

public class FaenaFormPresenter extends AbstractPresenterForm<Faena, FaenaService> {
    @Inject
    public FaenaFormPresenter(FaenaService servicio) {
        super(servicio);
    }
}