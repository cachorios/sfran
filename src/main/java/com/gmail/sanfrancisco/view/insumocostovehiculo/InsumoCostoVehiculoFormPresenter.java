package com.gmail.sanfrancisco.view.insumocostovehiculo;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;
import com.gmail.sanfrancisco.serviciosModelo.InsumoCostoVehiculoService;

import javax.inject.Inject;

public class InsumoCostoVehiculoFormPresenter extends AbstractPresenterForm<InsumoCostoVehiculo, InsumoCostoVehiculoService> {
    @Inject
    public InsumoCostoVehiculoFormPresenter(InsumoCostoVehiculoService servicio) { super(servicio); }
}
