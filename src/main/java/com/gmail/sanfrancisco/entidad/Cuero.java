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
public @Data class Cuero extends AbstractEntidad {

//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)

    @NotNull
    private Date fecha;

    @Override
    public String toString() {
        return isNew() ? "Nuevo costo de cuero" : this.getFecha().toString();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuero", fetch = FetchType.LAZY)
    private List<CueroDetalleInsumo> insumos;

    public Cuero() {
        insumos = new ArrayList<>();
    }

    public List<CueroDetalleInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<CueroDetalleInsumo> insumos) {
        this.insumos = insumos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(CueroDetalleInsumo ins: insumos){
            if(ins.getCuero() == null){
                ins.setCuero(this);
            }
        }
    }
}
