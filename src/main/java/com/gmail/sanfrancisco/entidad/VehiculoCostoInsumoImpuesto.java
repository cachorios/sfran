package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

@Entity
public class VehiculoCostoInsumoImpuesto extends AbstractEntidad {
    @ManyToOne
    private VehiculoCostoInsumo vehiculoCostoInsumo;

    @NotNull
    @ManyToOne
    private Parametro impuesto;

    @NotNull
    private Double saldo;

    public VehiculoCostoInsumo getVehiculoCostoInsumo() {
        return vehiculoCostoInsumo;
    }

    public void setVehiculoCostoInsumo(VehiculoCostoInsumo vehiculoCostoInsumo) {
        this.vehiculoCostoInsumo = vehiculoCostoInsumo;
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
        return isNew() ? "Nuevo impuesto de insumo de costo de vehiculo" : this.getImpuesto().toString();
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
