package com.gmail.sanfrancisco.view.graseriacostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumoImpuesto;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaCostoInsumoImpuestoService;

import javax.inject.Inject;

public class GraseriaCostoInsumoImpuestoFormPresenter extends AbstractPresenterForm<GraseriaCostoInsumoImpuesto, GraseriaCostoInsumoImpuestoService> {
    @Inject
    public GraseriaCostoInsumoImpuestoFormPresenter(GraseriaCostoInsumoImpuestoService servicio) { super(servicio); }
}