package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Mantenimiento extends AbstractEntidad {
    @NotNull
    private Date fecha;

    @ManyToOne
    private Vehiculo vehiculo;

    public String toString() {
        return this.getFecha().toString();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mantenimiento", fetch = FetchType.LAZY)
    private List<MantenimientoDetalleInsumo> insumos;

    public Mantenimiento() {
        insumos = new ArrayList<>();
    }

    public List<MantenimientoDetalleInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<MantenimientoDetalleInsumo> insumos) {
        this.insumos = insumos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(MantenimientoDetalleInsumo ins: insumos){
            if(ins.getMantenimiento() == null){
                ins.setMantenimiento(this);
            }
        }
    }
}
