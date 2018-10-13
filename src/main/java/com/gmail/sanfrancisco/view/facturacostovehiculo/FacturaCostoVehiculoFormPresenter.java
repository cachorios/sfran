package com.gmail.sanfrancisco.view.facturacostovehiculo;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.FacturaCostoVehiculo;
import com.gmail.sanfrancisco.serviciosModelo.FacturaCostoVehiculoService;

import javax.inject.Inject;

public class FacturaCostoVehiculoFormPresenter extends AbstractPresenterForm<FacturaCostoVehiculo, FacturaCostoVehiculoService> {
    @Inject
    public FacturaCostoVehiculoFormPresenter(FacturaCostoVehiculoService servicio) { super(servicio); }
}