package com.gmail.sanfrancisco.view.vehiculo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.gmail.sanfrancisco.serviciosModelo.VehiculoService;

import javax.inject.Inject;

public class VehiculoListPresenter extends AbstractPresenterList<Vehiculo, VehiculoService> {
    @Inject
    public VehiculoListPresenter(VehiculoService servicio, FilterablePageableDataProvider<Vehiculo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
