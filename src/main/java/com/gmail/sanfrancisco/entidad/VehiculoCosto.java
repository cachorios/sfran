package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
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

    public String toString() {
        return this.getFecha().toString();
    }

    public List<VehiculoCostoInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<VehiculoCostoInsumo> insumos) {
        this.insumos = insumos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){
        for(VehiculoCostoInsumo ins: insumos){
            if(ins.getVehiculoCosto() == null){
                ins.setVehiculoCosto(this);
            }
        }
    }
}
