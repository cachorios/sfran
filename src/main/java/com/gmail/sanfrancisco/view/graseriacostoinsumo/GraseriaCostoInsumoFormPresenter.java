package com.gmail.sanfrancisco.view.graseriacostoinsumo;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumo;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaCostoInsumoService;

import javax.inject.Inject;

public class GraseriaCostoInsumoFormPresenter extends AbstractPresenterForm<GraseriaCostoInsumo, GraseriaCostoInsumoService> {
    @Inject
    public GraseriaCostoInsumoFormPresenter(GraseriaCostoInsumoService servicio) { super(servicio); }
}
