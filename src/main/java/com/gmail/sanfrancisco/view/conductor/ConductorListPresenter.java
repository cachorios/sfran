package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.gmail.sanfrancisco.serviciosModelo.ConductorService;

import javax.inject.Inject;

public class ConductorListPresenter extends AbstractPresenterList<Conductor, ConductorService> {
    @Inject
    public ConductorListPresenter(ConductorService servicio, FilterablePageableDataProvider<Conductor, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}

