package com.gmail.sanfrancisco.view.graseria;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Graseria;
import com.gmail.sanfrancisco.serviciosModelo.GraseriaService;

import javax.inject.Inject;

public class GraseriaListPresenter extends AbstractPresenterList<Graseria, GraseriaService> {
    @Inject
    public GraseriaListPresenter(GraseriaService servicio, FilterablePageableDataProvider<Graseria, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
