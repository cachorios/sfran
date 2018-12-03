package com.gmail.sanfrancisco.view.graseriacosto;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.GraseriaCosto;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaCostoService;

import javax.inject.Inject;

public class GraseriaCostoFormPresenter extends AbstractPresenterForm<GraseriaCosto, GraseriaCostoService> {
    @Inject
    public GraseriaCostoFormPresenter(GraseriaCostoService servicio) { super(servicio); }
}
