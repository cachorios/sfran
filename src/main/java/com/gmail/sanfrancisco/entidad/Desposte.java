package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public @Data class Desposte extends AbstractEntidad {
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    @NotNull
    private Date fecha;

    public String toString() {
        return this.getFecha().toString();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desposte", fetch = FetchType.LAZY)
    private List<DespoteDetalleInsumo> insumos;

    public Desposte() {
        insumos = new ArrayList<>();
    }

    public List<DespoteDetalleInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<DespoteDetalleInsumo> insumos) {
        this.insumos = insumos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(DespoteDetalleInsumo ins: insumos){
            if(ins.getDesposte() == null){
                ins.setDesposte(this);
            }
        }
    }
}
