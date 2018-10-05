package com.gmail.sanfrancisco.view.licencia;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.gmail.sanfrancisco.serviciosModelo.LicenciaService;

import javax.inject.Inject;

public class LicenciaListPresenter extends AbstractPresenterList<Licencia, LicenciaService> {
    @Inject
    public LicenciaListPresenter(LicenciaService servicio, FilterablePageableDataProvider<Licencia, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
