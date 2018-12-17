package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class VehiculoCosto extends AbstractEntidad {
    @NotNull
    private Date fecha;

    @ManyToOne
    private Vehiculo vehiculo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoCosto", fetch = FetchType.LAZY)
    private List<VehiculoCostoInsumo> insumos;

    public VehiculoCosto() {
        insumos = new ArrayList<>();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo Costo de vehiculo" : this.getFecha().toString();
    }

    public List<VehiculoCostoInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<VehiculoCostoInsumo> insumos) {
        this.insumos = insumos;
    }

    @Override
    @PrePersist
    protected void setAltaData() {
        super.setAltaData();
        for(VehiculoCostoInsumo ins: insumos){
            if(ins.getVehiculoCosto() == null){
                ins.setVehiculoCosto(this);
            }
        }
    }

    @Override
    @PreUpdate
    protected void setUmodData() {
        super.setUmodData();
        for(VehiculoCostoInsumo ins: insumos){
            if(ins.getVehiculoCosto() == null){
                ins.setVehiculoCosto(this);
            }
        }
    }
}
