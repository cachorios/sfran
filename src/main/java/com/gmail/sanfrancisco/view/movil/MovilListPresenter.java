package com.gmail.sanfrancisco.view.movil;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.gmail.sanfrancisco.serviciosModelo.MovilService;

import javax.inject.Inject;

public class MovilListPresenter extends AbstractPresenterList<Vehiculo, MovilService> {
    @Inject
    public MovilListPresenter(MovilService servicio, FilterablePageableDataProvider<Vehiculo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
