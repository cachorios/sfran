package com.gmail.sanfrancisco.view.renspa;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.gmail.sanfrancisco.serviciosModelo.RenspaService;

import javax.inject.Inject;

public class RenspaListPresenter extends AbstractPresenterList<Renspa, RenspaService> {
    @Inject
    public RenspaListPresenter(RenspaService servicio, FilterablePageableDataProvider<Renspa, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
