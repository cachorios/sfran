package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class InsumoCostoVehiculo extends AbstractEntidad {
    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;

    @ManyToOne
    private FacturaCostoVehiculo facturaCostoVehiculo;

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

    public FacturaCostoVehiculo getFacturaCostoVehiculo() {
        return facturaCostoVehiculo;
    }

    public void setFacturaCostoVehiculo(FacturaCostoVehiculo facturaCostoVehiculo) {
        this.facturaCostoVehiculo = facturaCostoVehiculo;
    }
}
