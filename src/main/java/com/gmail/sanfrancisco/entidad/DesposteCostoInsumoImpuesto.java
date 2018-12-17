package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

@Entity
public class DesposteCostoInsumoImpuesto extends AbstractEntidad {
    @ManyToOne
    private DesposteCostoInsumo desposteCostoInsumo;

    @ManyToOne
    @NotNull
    private Parametro impuesto;

    @NotNull
    private Double saldo;

    public DesposteCostoInsumo getDesposteCostoInsumo() {
        return desposteCostoInsumo;
    }

    public void setDesposteCostoInsumo(DesposteCostoInsumo desposteCostoInsumo) {
        this.desposteCostoInsumo = desposteCostoInsumo;
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

    @Override
    public String toString() {
        return isNew() ? "Nuevo impuesto de insumo en desposte" : this.getImpuesto().toString();
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
