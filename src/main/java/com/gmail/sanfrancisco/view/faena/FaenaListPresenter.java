package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Faena;
import com.gmail.sanfrancisco.serviciosModelo.FaenaService;

import javax.inject.Inject;

public class FaenaListPresenter extends AbstractPresenterList<Faena, FaenaService> {
    @Inject
    public FaenaListPresenter(FaenaService servicio, FilterablePageableDataProvider<Faena, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
