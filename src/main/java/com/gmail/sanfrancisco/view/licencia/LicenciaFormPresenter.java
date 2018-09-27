package com.gmail.sanfrancisco.view.licencia;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.gmail.sanfrancisco.serviciosModelo.ConductorService;
import com.gmail.sanfrancisco.serviciosModelo.LicenciaService;

import javax.inject.Inject;

public class LicenciaFormPresenter extends AbstractPresenterForm<Licencia, LicenciaService> {
    @Inject
    public LicenciaFormPresenter(LicenciaService servicio) {
        super(servicio);
    }
}
