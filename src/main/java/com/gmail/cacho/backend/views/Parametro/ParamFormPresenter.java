package com.gmail.cacho.backend.views.Parametro;



import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.service.ParametroServicio;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;

import javax.inject.Inject;

public class ParamFormPresenter extends AbstractPresenterForm<Parametro, ParametroServicio> {
    @Inject
    public ParamFormPresenter(ParametroServicio servicio) {
        super(servicio);
    }
}
