package com.gmail.sanfrancisco.view.consignatario;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.gmail.sanfrancisco.serviciosModelo.ConsignatarioService;

import javax.inject.Inject;

public class ConsignatarioFormPresenter extends AbstractPresenterForm<Consignatario, ConsignatarioService> {
    @Inject
    public ConsignatarioFormPresenter(ConsignatarioService servicio) { super(servicio); }
}
