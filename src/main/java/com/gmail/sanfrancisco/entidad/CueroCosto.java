package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public  class CueroCosto extends AbstractEntidad {
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    @NotNull
    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo costo de cuero" : this.getFecha().toString();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cueroCosto", fetch = FetchType.LAZY)
    private List<CueroCostoInsumo> insumos;

    public CueroCosto() {
        insumos = new ArrayList<>();
    }

    public List<CueroCostoInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<CueroCostoInsumo> insumos) {
        this.insumos = insumos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(CueroCostoInsumo ins: insumos){
            if(ins.getCueroCosto() == null){
                ins.setCueroCosto(this);
            }
        }
    }
}
