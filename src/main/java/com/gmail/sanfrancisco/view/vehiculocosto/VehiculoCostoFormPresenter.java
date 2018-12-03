package com.gmail.sanfrancisco.view.vehiculocosto;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.VehiculoCosto;
import com.gmail.sanfrancisco.serviciosModelo.VehiculoCostoService;

import javax.inject.Inject;

public class VehiculoCostoFormPresenter extends AbstractPresenterForm<VehiculoCosto, VehiculoCostoService> {
    @Inject
    public VehiculoCostoFormPresenter(VehiculoCostoService servicio) { super(servicio); }
}