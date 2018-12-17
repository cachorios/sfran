package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class GraseriaCosto extends AbstractEntidad {
    @NotNull
    private Date fecha;

    @Override
    public String toString() {
        return isNew() ? "Nuevo costo de graseria" : this.getFecha().toString();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "graseriaCosto", fetch = FetchType.LAZY)
    private List<GraseriaCostoInsumo> insumos;

    public GraseriaCosto() {
        insumos = new ArrayList<>();
    }

    public List<GraseriaCostoInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<GraseriaCostoInsumo> insumos) {
        this.insumos = insumos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(GraseriaCostoInsumo ins: insumos){
            if(ins.getGraseriaCosto() == null){
                ins.setGraseriaCosto(this);
            }
        }
    }


}
