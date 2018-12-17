package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VehiculoCostoInsumo extends AbstractEntidad {
    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Double cantidad;

    @NotNull
    private Double precio;

    @ManyToOne
    private VehiculoCosto vehiculoCosto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoCostoInsumo", fetch = FetchType.LAZY)
    private List<VehiculoCostoInsumoImpuesto> impuestos;

    public VehiculoCostoInsumo() {
        impuestos = new ArrayList<>();
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public VehiculoCosto getVehiculoCosto() {
        return vehiculoCosto;
    }

    public void setVehiculoCosto(VehiculoCosto vehiculoCosto) {
        this.vehiculoCosto = vehiculoCosto;
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo insumo en costo de vehiculo" : this.getInsumo().toString();
    }

    public List<VehiculoCostoInsumoImpuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<VehiculoCostoInsumoImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @Override
    @PrePersist
    protected void setAltaData() {
        super.setAltaData();
        for(VehiculoCostoInsumoImpuesto imp: impuestos){
            if(imp.getVehiculoCostoInsumo() == null){
                imp.setVehiculoCostoInsumo(this);
            }
        }
    }

    @Override
    @PreUpdate
    protected void setUmodData() {
        super.setUmodData();
        for(VehiculoCostoInsumoImpuesto imp: impuestos){
            if(imp.getVehiculoCostoInsumo() == null){
                imp.setVehiculoCostoInsumo(this);
            }
        }
    }
}
