package com.gmail.sanfrancisco.view.cuerocostoinsumoimpuesto;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumoImpuesto;
import com.gmail.sanfrancisco.serviciosModelo.CueroCostoInsumoImpuestoService;

import javax.inject.Inject;

public class CueroCostoInsumoImpuestoListPresenter extends AbstractPresenterList<CueroCostoInsumoImpuesto, CueroCostoInsumoImpuestoService> {
    @Inject
    public CueroCostoInsumoImpuestoListPresenter(CueroCostoInsumoImpuestoService servicio, FilterablePageableDataProvider<CueroCostoInsumoImpuesto, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}