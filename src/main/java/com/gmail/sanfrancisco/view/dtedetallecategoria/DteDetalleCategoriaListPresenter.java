package com.gmail.sanfrancisco.view.dtedetallecategoria;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.gmail.sanfrancisco.serviciosModelo.DteDetalleCategoriaService;

import javax.inject.Inject;

public class DteDetalleCategoriaListPresenter extends AbstractPresenterList<DteDetalleCategoria, DteDetalleCategoriaService> {
    @Inject
    public DteDetalleCategoriaListPresenter(DteDetalleCategoriaService servicio, FilterablePageableDataProvider<DteDetalleCategoria, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}