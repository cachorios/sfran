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
public class Faena extends AbstractEntidad {
    @NotNull
    private Date fecha;

    public String toString() {
        return this.getFecha().toString();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faena", fetch = FetchType.LAZY)
    private List<FaenaDetalleInsumo> insumos;

    public Faena() {
        insumos = new ArrayList<>();
    }

    public List<FaenaDetalleInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<FaenaDetalleInsumo> insumos) {
        this.insumos = insumos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(FaenaDetalleInsumo ins: insumos){
            if(ins.getFaena() == null){
                ins.setFaena(this);
            }
        }
    }
}
