package com.gmail.sanfrancisco.view.vehiculocostoinsumo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumo;
import com.gmail.sanfrancisco.serviciosModelo.VehiculoCostoInsumoService;

import javax.inject.Inject;

public class VehiculoCostoInsumoListPresenter extends AbstractPresenterList<VehiculoCostoInsumo, VehiculoCostoInsumoService> {
    @Inject
    public VehiculoCostoInsumoListPresenter(VehiculoCostoInsumoService servicio, FilterablePageableDataProvider<VehiculoCostoInsumo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}