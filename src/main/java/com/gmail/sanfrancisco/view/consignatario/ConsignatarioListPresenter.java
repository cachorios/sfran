package com.gmail.sanfrancisco.view.consignatario;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.gmail.sanfrancisco.serviciosModelo.ConsignatarioService;

import javax.inject.Inject;

public class ConsignatarioListPresenter extends AbstractPresenterList<Consignatario, ConsignatarioService> {
    @Inject
    public ConsignatarioListPresenter(ConsignatarioService servicio, FilterablePageableDataProvider<Consignatario, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }

}
