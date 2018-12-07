package com.gmail.sanfrancisco.view.cuerocostoinsumo;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumo;
import com.gmail.sanfrancisco.serviciosModelo.CueroCostoInsumoService;

import javax.inject.Inject;

public class CueroCostoInsumoFormPresenter extends AbstractPresenterForm<CueroCostoInsumo, CueroCostoInsumoService> {
    @Inject
    public CueroCostoInsumoFormPresenter(CueroCostoInsumoService servicio) { super(servicio); }
}