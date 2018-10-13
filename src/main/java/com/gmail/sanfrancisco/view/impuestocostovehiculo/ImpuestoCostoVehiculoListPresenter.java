package com.gmail.sanfrancisco.view.impuestocostovehiculo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.ImpuestoCostoVehiculo;
import com.gmail.sanfrancisco.serviciosModelo.ImpuestoCostoVehiculoService;

import javax.inject.Inject;

public class ImpuestoCostoVehiculoListPresenter extends AbstractPresenterList<ImpuestoCostoVehiculo, ImpuestoCostoVehiculoService> {
    @Inject
    public ImpuestoCostoVehiculoListPresenter(ImpuestoCostoVehiculoService servicio, FilterablePageableDataProvider<ImpuestoCostoVehiculo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}