package com.gmail.sanfrancisco.view.graseriacostoinsumoimpuesto;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumoImpuesto;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaCostoInsumoImpuestoService;

import javax.inject.Inject;

public class GraseriaCostoInsumoImpuestoListPresenter extends AbstractPresenterList<GraseriaCostoInsumoImpuesto, GraseriaCostoInsumoImpuestoService> {
    @Inject
    public GraseriaCostoInsumoImpuestoListPresenter(GraseriaCostoInsumoImpuestoService servicio, FilterablePageableDataProvider<GraseriaCostoInsumoImpuesto, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}