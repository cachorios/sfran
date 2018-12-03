package com.gmail.sanfrancisco.view.graseriacostoinsumo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumo;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaCostoInsumoService;

import javax.inject.Inject;

public class GraseriaCostoInsumoListPresenter extends AbstractPresenterList<GraseriaCostoInsumo, GraseriaCostoInsumoService> {
    @Inject
    public GraseriaCostoInsumoListPresenter(GraseriaCostoInsumoService servicio, FilterablePageableDataProvider<GraseriaCostoInsumo, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
