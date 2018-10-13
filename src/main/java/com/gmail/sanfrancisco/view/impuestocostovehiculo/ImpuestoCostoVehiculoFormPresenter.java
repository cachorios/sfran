package com.gmail.sanfrancisco.view.impuestocostovehiculo;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.ImpuestoCostoVehiculo;
import com.gmail.sanfrancisco.serviciosModelo.ImpuestoCostoVehiculoService;

import javax.inject.Inject;

public class ImpuestoCostoVehiculoFormPresenter extends AbstractPresenterForm<ImpuestoCostoVehiculo, ImpuestoCostoVehiculoService> {
    @Inject
    public ImpuestoCostoVehiculoFormPresenter(ImpuestoCostoVehiculoService servicio) { super(servicio); }
}