package com.gmail.sanfrancisco.view.insumocostovehiculo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;
import com.gmail.sanfrancisco.serviciosModelo.InsumoCostoVehiculoService;

import javax.inject.Inject;

public class InsumoCostoVehiculoListPresenter extends AbstractPresenterList<InsumoCostoVehiculo, InsumoCostoVehiculoService> {
    @Inject
    public InsumoCostoVehiculoListPresenter(InsumoCostoVehiculoService servicio, FilterablePageableDataProvider<InsumoCostoVehiculo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}