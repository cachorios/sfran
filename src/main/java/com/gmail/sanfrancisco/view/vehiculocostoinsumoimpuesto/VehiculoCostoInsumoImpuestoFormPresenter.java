package com.gmail.sanfrancisco.view.vehiculocostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumoImpuesto;
import com.gmail.sanfrancisco.serviciosModelo.VehiculoCostoInsumoImpuestoService;

import javax.inject.Inject;

public class VehiculoCostoInsumoImpuestoFormPresenter extends AbstractPresenterForm<VehiculoCostoInsumoImpuesto, VehiculoCostoInsumoImpuestoService> {
    @Inject
    public VehiculoCostoInsumoImpuestoFormPresenter(VehiculoCostoInsumoImpuestoService servicio) { super(servicio); }
}