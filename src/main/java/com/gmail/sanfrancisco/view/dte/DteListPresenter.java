package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.dataProvider.DteDataProvider;
import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.serviciosModelo.DteService;

import javax.inject.Inject;

public class DteListPresenter extends AbstractPresenterList<Dte, DteService> {
    @Inject
    public DteListPresenter(DteService servicio, DteDataProvider dataProvider) {
        super(servicio, dataProvider);
    }
}