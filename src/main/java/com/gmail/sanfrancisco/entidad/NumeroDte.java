package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class NumeroDte extends AbstractEntidad {
    @NotNull
    @Size(min=3, max=50, message="La descripción debe contener entre 3 y 50 caracteres.")
    private String descripcion;

    @ManyToOne
    private Dte dte;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dte getDte() {
        return dte;
    }

    public void setDte(Dte dte) {
        this.dte = dte;
    }
}
