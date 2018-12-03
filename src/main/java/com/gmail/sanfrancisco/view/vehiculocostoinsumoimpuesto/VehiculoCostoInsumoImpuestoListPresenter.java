package com.gmail.sanfrancisco.view.vehiculocostoinsumoimpuesto;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumoImpuesto;
import com.gmail.sanfrancisco.serviciosModelo.VehiculoCostoInsumoImpuestoService;

import javax.inject.Inject;

public class VehiculoCostoInsumoImpuestoListPresenter extends AbstractPresenterList<VehiculoCostoInsumoImpuesto, VehiculoCostoInsumoImpuestoService> {
    @Inject
    public VehiculoCostoInsumoImpuestoListPresenter(VehiculoCostoInsumoImpuestoService servicio, FilterablePageableDataProvider<VehiculoCostoInsumoImpuesto, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}