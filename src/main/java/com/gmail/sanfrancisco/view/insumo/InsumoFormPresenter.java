package com.gmail.sanfrancisco.view.insumo;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.gmail.sanfrancisco.serviciosModelo.InsumoService;

import javax.inject.Inject;

public class InsumoFormPresenter extends AbstractPresenterForm<Insumo, InsumoService> {
    @Inject
    public InsumoFormPresenter(InsumoService servicio) { super(servicio); }
}
