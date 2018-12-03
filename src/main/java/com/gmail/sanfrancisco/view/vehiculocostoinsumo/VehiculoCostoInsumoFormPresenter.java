package com.gmail.sanfrancisco.view.vehiculocostoinsumo;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumo;
import com.gmail.sanfrancisco.serviciosModelo.VehiculoCostoInsumoService;

import javax.inject.Inject;

public class VehiculoCostoInsumoFormPresenter extends AbstractPresenterForm<VehiculoCostoInsumo, VehiculoCostoInsumoService> {
    @Inject
    public VehiculoCostoInsumoFormPresenter(VehiculoCostoInsumoService servicio) { super(servicio); }
}
