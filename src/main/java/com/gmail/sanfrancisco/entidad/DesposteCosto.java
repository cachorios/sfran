package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public  class DesposteCosto extends AbstractEntidad {
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    @NotNull
    private Date fecha;

    @Override
    public String toString() {
        return isNew() ? "Nuevo costo de desposte" : this.getFecha().toString();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desposteCosto", fetch = FetchType.LAZY)
    private List<DesposteCostoInsumo> insumos;

    public DesposteCosto() {
        insumos = new ArrayList<>();
    }

    public List<DesposteCostoInsumo> getInsumos() {
        return insumos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setInsumos(List<DesposteCostoInsumo> insumos) {
        this.insumos = insumos;
    }


    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(DesposteCostoInsumo ins: insumos){
            if(ins.getDesposteCosto() == null){
                ins.setDesposteCosto(this);
            }
        }
    }
}
