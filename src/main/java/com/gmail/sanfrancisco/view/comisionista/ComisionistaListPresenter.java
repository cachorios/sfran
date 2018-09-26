package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.gmail.sanfrancisco.serviciosModelo.ComisionistaService;

import javax.inject.Inject;

public class ComisionistaListPresenter extends AbstractPresenterList<Comisionista, ComisionistaService> {
    @Inject
    public ComisionistaListPresenter(ComisionistaService servicio, FilterablePageableDataProvider<Comisionista, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
