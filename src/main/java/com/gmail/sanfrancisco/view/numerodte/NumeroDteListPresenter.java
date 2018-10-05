package com.gmail.sanfrancisco.view.numerodte;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.NumeroDte;
import com.gmail.sanfrancisco.serviciosModelo.NumeroDteService;

import javax.inject.Inject;

public class NumeroDteListPresenter extends AbstractPresenterList<NumeroDte, NumeroDteService> {
    @Inject
    public NumeroDteListPresenter(NumeroDteService servicio, FilterablePageableDataProvider<NumeroDte, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
