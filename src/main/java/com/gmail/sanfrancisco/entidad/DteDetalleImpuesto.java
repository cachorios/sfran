package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class DteDetalleImpuesto extends AbstractEntidad {
    @ManyToOne
    private Dte dte;

    @NotNull
    private long impuesto;

    @NotNull
    private Double saldo;

    public Dte getDte() {
        return dte;
    }

    public void setDte(Dte dte) {
        this.dte = dte;
    }

    public long getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(long impuesto) {
        this.impuesto = impuesto;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
