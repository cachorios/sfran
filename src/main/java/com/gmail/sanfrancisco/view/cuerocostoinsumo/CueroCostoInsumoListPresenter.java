package com.gmail.sanfrancisco.view.cuerocostoinsumo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumo;
import com.gmail.sanfrancisco.serviciosModelo.CueroCostoInsumoService;

import javax.inject.Inject;

public class CueroCostoInsumoListPresenter extends AbstractPresenterList<CueroCostoInsumo, CueroCostoInsumoService> {
    @Inject
    public CueroCostoInsumoListPresenter(CueroCostoInsumoService servicio, FilterablePageableDataProvider<CueroCostoInsumo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}