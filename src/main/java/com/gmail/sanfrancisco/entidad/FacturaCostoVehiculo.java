package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class FacturaCostoVehiculo extends AbstractEntidad {
    @NotNull
    private Date fecha;

    @ManyToOne
    private Movil movil;
}
