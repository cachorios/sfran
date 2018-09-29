package com.gmail.sanfrancisco.view.movil;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Movil;
import com.gmail.sanfrancisco.serviciosModelo.MovilService;

import javax.inject.Inject;

public class MovilListPresenter extends AbstractPresenterList<Movil, MovilService> {
    @Inject
    public MovilListPresenter(MovilService servicio, FilterablePageableDataProvider<Movil, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
