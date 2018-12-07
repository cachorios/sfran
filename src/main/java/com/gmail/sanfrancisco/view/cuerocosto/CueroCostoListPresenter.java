package com.gmail.sanfrancisco.view.cuerocosto;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.CueroCosto;
import com.gmail.sanfrancisco.serviciosModelo.CueroCostoService;

import javax.inject.Inject;

public class CueroCostoListPresenter extends AbstractPresenterList<CueroCosto, CueroCostoService> {
    @Inject
    public CueroCostoListPresenter(CueroCostoService servicio, FilterablePageableDataProvider<CueroCosto, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}