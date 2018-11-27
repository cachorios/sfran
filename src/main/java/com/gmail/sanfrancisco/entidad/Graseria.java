package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.slapi.view.renders.DateRenderer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Graseria extends AbstractEntidad {
    @NotNull
    private Date fecha;

    public String toString() {
        return this.getFecha().toString();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumo", fetch = FetchType.LAZY)
    private List<GraseriaDetalleInsumo> insumos;

    public Graseria() {
        insumos = new ArrayList<>();
    }

    public List<GraseriaDetalleInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<GraseriaDetalleInsumo> insumos) {
        this.insumos = insumos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(GraseriaDetalleInsumo ins: insumos){
            if(ins.getGraseria() == null){
                ins.setGraseria(this);
            }
        }
    }
}
