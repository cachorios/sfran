package com.gmail.sanfrancisco.view.vehiculocosto;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.VehiculoCosto;
import com.gmail.sanfrancisco.serviciosModelo.VehiculoCostoService;

import javax.inject.Inject;

public class VehiculoCostoListPresenter extends AbstractPresenterList<VehiculoCosto, VehiculoCostoService> {
    @Inject
    public VehiculoCostoListPresenter(VehiculoCostoService servicio, FilterablePageableDataProvider<VehiculoCosto, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}