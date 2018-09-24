package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class DespoteDetalle extends AbstractEntidad {
    @ManyToOne
    private Desposte desposte;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;

    @NotNull
    private Double subtotal;

    public Desposte getDesposte() {
        return desposte;
    }

    public void setDesposte(Desposte desposte) {
        this.desposte = desposte;
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
