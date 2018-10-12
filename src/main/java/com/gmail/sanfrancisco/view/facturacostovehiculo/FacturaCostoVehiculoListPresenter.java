package com.gmail.sanfrancisco.view.facturacostovehiculo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.FacturaCostoVehiculo;
import com.gmail.sanfrancisco.serviciosModelo.FacturaCostoVehiculoService;

import javax.inject.Inject;

public class FacturaCostoVehiculoListPresenter extends AbstractPresenterList<FacturaCostoVehiculo, FacturaCostoVehiculoService> {
    @Inject
    public FacturaCostoVehiculoListPresenter(FacturaCostoVehiculoService servicio, FilterablePageableDataProvider<FacturaCostoVehiculo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}