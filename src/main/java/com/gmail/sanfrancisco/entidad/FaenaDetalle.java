package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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


    public FaenaDetalle(@NotNull Integer orden, @NotNull Parametro categoria, @NotNull Double kgIzquierdo, @NotNull Double kgDerecho) {
        this.orden = orden;
        this.categoria = categoria;
        this.kgIzquierdo = kgIzquierdo;
        this.kgDerecho = kgDerecho;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Parametro getCategoria() {
        return categoria;
    }

    public void setCategoria(Parametro categoria) {
        this.categoria = categoria;
    }

    public Double getKgIzquierdo() {
        return kgIzquierdo;
    }

    public void setKgIzquierdo(Double kgIzquierdo) {
        this.kgIzquierdo = kgIzquierdo;
    }

    public Double getKgDerecho() {
        return kgDerecho;
    }

    public void setKgDerecho(Double kgDerecho) {
        this.kgDerecho = kgDerecho;
    }

    public FaenaCabezera getFaenaCabezera() {
        return faenaCabezera;
    }

    public void setFaenaCabezera(FaenaCabezera faenaCabezera) {
        this.faenaCabezera = faenaCabezera;
    }

    @Override
    public String toString() {
        return isNew() ? "Nueva Faena Detalle" : this.categoria.toString();
    }

    @Override
    @PrePersist
    protected void setAltaData() {
        super.setAltaData();
    }

    @Override
    @PreUpdate
    protected void setUmodData() {
        super.setUmodData();
    }
}
