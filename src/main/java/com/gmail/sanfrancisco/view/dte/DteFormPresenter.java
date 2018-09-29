package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.serviciosModelo.DteService;

import javax.inject.Inject;

public class DteFormPresenter extends AbstractPresenterForm<Dte, DteService> {
    @Inject
    public DteFormPresenter(DteService servicio) {
        super(servicio);
    }
}
