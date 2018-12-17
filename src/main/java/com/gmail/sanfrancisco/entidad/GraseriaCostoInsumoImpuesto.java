package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class GraseriaCostoInsumoImpuesto extends AbstractEntidad {
    @ManyToOne
    private GraseriaCostoInsumo graseriaCostoInsumo;

    @ManyToOne
    @NotNull
    private Parametro impuesto;

    @NotNull
    private Double saldo;

    public GraseriaCostoInsumo getGraseriaCostoInsumo() {
        return graseriaCostoInsumo;
    }

    public void setGraseriaCostoInsumo(GraseriaCostoInsumo graseriaCostoInsumo) {
        this.graseriaCostoInsumo = graseriaCostoInsumo;
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
        return isNew() ? "Nuevo impuesto de insumo en graseria" : this.getImpuesto().toString();
    }
}
