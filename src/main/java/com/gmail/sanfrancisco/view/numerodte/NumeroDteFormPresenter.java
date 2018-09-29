package com.gmail.sanfrancisco.view.numerodte;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.NumeroDte;
import com.gmail.sanfrancisco.serviciosModelo.NumeroDteService;

import javax.inject.Inject;

public class NumeroDteFormPresenter extends AbstractPresenterForm<NumeroDte, NumeroDteService> {
    @Inject
    public NumeroDteFormPresenter(NumeroDteService servicio) { super(servicio); }
}
