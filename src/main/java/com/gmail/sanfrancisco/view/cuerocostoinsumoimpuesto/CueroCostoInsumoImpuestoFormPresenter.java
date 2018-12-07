package com.gmail.sanfrancisco.view.cuerocostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumoImpuesto;
import com.gmail.sanfrancisco.serviciosModelo.CueroCostoInsumoImpuestoService;

import javax.inject.Inject;

public class CueroCostoInsumoImpuestoFormPresenter extends AbstractPresenterForm<CueroCostoInsumoImpuesto, CueroCostoInsumoImpuestoService> {
    @Inject
    public CueroCostoInsumoImpuestoFormPresenter(CueroCostoInsumoImpuestoService servicio) { super(servicio); }
}