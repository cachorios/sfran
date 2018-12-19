package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity

public class FaenaCabezera extends AbstractEntidad {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private DteDetalleCategoria categoria;

    @NotNull
    private Integer cantidad;

    private Integer faenado;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FaenaProductor faenaProductor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faenaCabezera", fetch = FetchType.LAZY)
    private List<FaenaDetalle> faenaDetalle;


    public FaenaCabezera() {
        faenado = 0;
        faenaDetalle = new ArrayList<>();
    }

    public DteDetalleCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(DteDetalleCategoria categoria) {
        this.categoria = categoria;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getFaenado() {
        return faenado;
    }

    public void setFaenado(Integer faenado) {
        this.faenado = faenado;
    }

    public FaenaProductor getFaenaProductor() {
        return faenaProductor;
    }

    public void setFaenaProductor(FaenaProductor faenaProductor) {
        this.faenaProductor = faenaProductor;
    }

    public List<FaenaDetalle> getFaenaDetalle() {
        return faenaDetalle;
    }

    public void setFaenaDetalle(List<FaenaDetalle> faenaDetalle) {
        this.faenaDetalle = faenaDetalle;
    }

    @Override
    public String toString() { return  isNew() ? "Nueva Faena Cabezera" : this.categoria.toString(); }

    @Override
    @PrePersist
    protected void setAltaData() {
        super.setAltaData();
        faenaDetalle.forEach(detalle -> detalle.setFaenaCabezera(this) );
    }

    @Override
    @PreUpdate
    protected void setUmodData() {
        super.setUmodData();
        faenaDetalle.forEach(detalle -> detalle.setFaenaCabezera(this) );
    }


}
