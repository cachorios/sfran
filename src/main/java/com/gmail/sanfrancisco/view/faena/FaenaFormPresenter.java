package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.cacho.slbase.core.Fecha;
import com.gmail.cacho.slbase.persist.excepciones.PersistErrorException;
import com.gmail.sanfrancisco.entidad.Faena;
import com.gmail.sanfrancisco.serviciosModelo.FaenaService;

import javax.inject.Inject;
import java.util.Date;

public class FaenaFormPresenter extends AbstractPresenterForm<Faena, FaenaService> {
    @Inject
    public FaenaFormPresenter(FaenaService servicio) {
        super(servicio);

        Faena faena = new Faena();
        faena.setFecha(new Date());
        faena.setNumero(12);
        try {
            servicio.save(faena);
        }catch (PersistErrorException e){
            e.printStackTrace();
        }

    }
}