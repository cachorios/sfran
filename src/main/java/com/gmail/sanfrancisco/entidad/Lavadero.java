package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Lavadero extends AbstractEntidad {
    @NotNull
    private Date fecha;

    @ManyToOne
    private Vehiculo vehiculo;

    public String toString() {
        return this.getFecha().toString();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lavadero", fetch = FetchType.LAZY)
    private List<LavaderoDetalleInsumo> insumos;

    public Lavadero() {
        insumos = new ArrayList<>();
    }

    public List<LavaderoDetalleInsumo> getInsumos() {
        return insumos;
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

    public void setInsumos(List<LavaderoDetalleInsumo> insumos) {
        this.insumos = insumos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(LavaderoDetalleInsumo ins: insumos){
            if(ins.getLavadero() == null){
                ins.setLavadero(this);
            }
        }
    }
}
