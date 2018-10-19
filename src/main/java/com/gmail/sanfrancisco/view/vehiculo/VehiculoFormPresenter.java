package com.gmail.sanfrancisco.view.vehiculo;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.gmail.sanfrancisco.serviciosModelo.VehiculoService;

import javax.inject.Inject;

public class VehiculoFormPresenter extends AbstractPresenterForm<Vehiculo, VehiculoService> {
    @Inject
    public VehiculoFormPresenter(VehiculoService servicio) { super(servicio); }
}
