package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Insumo extends AbstractEntidad {
    @NotNull
    @Size(min=3, max=100, message="La descripción debe contener entre 3 y 100 caracteres.")
    private String descripcion;

    @NotNull
    @ManyToOne
    private Parametro tipoInsumo;

    @NotNull
    private long unidad;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Parametro getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(Parametro tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    public long getUnidad() {
        return unidad;
    }

    public void setUnidad(long unidad) {
        this.unidad = unidad;
    }
}
