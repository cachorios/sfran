package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class DteDetalleCategoria extends AbstractEntidad {

    @ManyToOne
    private Dte dte;

    @ManyToOne
    private Productor productor;

    @ManyToOne
    private Renspa renspa;

    @NotNull
    @ManyToOne
    private Parametro categoria;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double kgVivo;

    @NotNull
    private Double precioKgVivo;

    @NotNull
    private Double kgCarne;

    @NotNull
    private Double porcentajeComision;


}
