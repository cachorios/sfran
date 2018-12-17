package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Viscera extends AbstractEntidad {
    @NotNull
    private Date fecha;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viscera", fetch = FetchType.LAZY)
    private List<VisceraDetalleInsumo> insumos;

    public Viscera() {
        insumos = new ArrayList<>();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<VisceraDetalleInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<VisceraDetalleInsumo> insumos) {
        this.insumos = insumos;
    }


    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(VisceraDetalleInsumo ins: insumos){
            if(ins.getViscera() == null){
                ins.setViscera(this);
            }
        }
    }

    public String toString() {
        return this.getFecha().toString();
    }
}
