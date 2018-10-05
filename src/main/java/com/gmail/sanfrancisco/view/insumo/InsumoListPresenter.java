package com.gmail.sanfrancisco.view.insumo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.gmail.sanfrancisco.serviciosModelo.InsumoService;

import javax.inject.Inject;

public class InsumoListPresenter extends AbstractPresenterList<Insumo, InsumoService> {
    @Inject
    public InsumoListPresenter(InsumoService servicio, FilterablePageableDataProvider<Insumo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
