package com.gmail.sanfrancisco.view.graseriacosto;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.GraseriaCosto;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaCostoService;

import javax.inject.Inject;

public class GraseriaCostoListPresenter extends AbstractPresenterList<GraseriaCosto, GraseriaCostoService> {
    @Inject
    public GraseriaCostoListPresenter(GraseriaCostoService servicio, FilterablePageableDataProvider<GraseriaCosto, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
