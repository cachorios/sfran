package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ImpuestoCostoVehiculo extends AbstractEntidad {
    @ManyToOne
    private InsumoCostoVehiculo insumocostovehiculo;

    @NotNull
    @ManyToOne
    private Parametro impuesto;

    @NotNull
    private Double saldo;

    public InsumoCostoVehiculo getInsumocostovehiculo() {
        return insumocostovehiculo;
    }

    public void setInsumocostovehiculo(InsumoCostoVehiculo insumocostovehiculo) {
        this.insumocostovehiculo = insumocostovehiculo;
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
