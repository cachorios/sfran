package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class GraseriaDetalleImpuesto extends AbstractEntidad {
    @ManyToOne
    private GraseriaDetalleInsumo graseriaDetalleInsumo;

    @ManyToOne
    @NotNull
    private Parametro impuesto;

    @NotNull
    private Double saldo;

    public GraseriaDetalleInsumo getGraseriaDetalleInsumo() {
        return graseriaDetalleInsumo;
    }

    public void setGraseriaDetalleInsumo(GraseriaDetalleInsumo graseriaDetalleInsumo) {
        this.graseriaDetalleInsumo = graseriaDetalleInsumo;
    }

    public Parametro getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Parametro impuesto) {
        this.impuesto = impuesto;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
