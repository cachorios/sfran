package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity

public class FaenaDetalle extends AbstractEntidad {
    @NotNull
    private Integer orden;

    @NotNull
    @ManyToOne
    private Parametro categoria;

    @NotNull
    private Double kgIzquierdo;

    @NotNull
    private Double kgDerecho;

    @ManyToOne
    private FaenaCabezera faenaCabezera;

    @Override
    public String toString() {
        return isNew() ? "Nueva Faena Detalle" : this.categoria.toString();
    }
}
