package com.gmail.cacho.backend.views.parametro;



import com.gmail.cacho.backend.dataprovider.ParamDataProvider;
import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.service.ParametroServicio;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;

import javax.inject.Inject;

public class ParamListPresenter extends AbstractPresenterList<Parametro, ParametroServicio> {
    @Inject
    public ParamListPresenter(ParametroServicio servicio, ParamDataProvider provider) {
        super(servicio, provider);
    }
}
