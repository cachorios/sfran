package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class GraseriaDetalle extends AbstractEntidad {
    @ManyToOne
    private Graseria graseria;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;

    @NotNull
    private Double subtotal;

    public Graseria getGraseria() {
        return graseria;
    }

    public void setGraseria(Graseria graseria) {
        this.graseria = graseria;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
