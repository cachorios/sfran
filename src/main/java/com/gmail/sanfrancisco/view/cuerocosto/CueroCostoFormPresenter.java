package com.gmail.sanfrancisco.view.cuerocosto;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.CueroCosto;
import com.gmail.sanfrancisco.serviciosModelo.CueroCostoService;

import javax.inject.Inject;

public class CueroCostoFormPresenter extends AbstractPresenterForm<CueroCosto, CueroCostoService> {
    @Inject
    public CueroCostoFormPresenter(CueroCostoService servicio) { super(servicio); }
}