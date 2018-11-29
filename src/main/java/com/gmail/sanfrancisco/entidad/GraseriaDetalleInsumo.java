package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude="graseria")
public class GraseriaDetalleInsumo extends AbstractEntidad {
    @ManyToOne
    private Graseria graseria;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "graseriaDetalleInsumo", fetch = FetchType.LAZY)
    private List<GraseriaDetalleImpuesto> impuestos;

    public GraseriaDetalleInsumo() {
        impuestos = new ArrayList<>();
    }

    public List<GraseriaDetalleImpuesto> getInsumos() {
        return impuestos;
    }

    public void setInsumos(List<GraseriaDetalleImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(GraseriaDetalleImpuesto imp: impuestos){
            if(imp.getGraseriaDetalleInsumo() == null){
                imp.setGraseriaDetalleInsumo(this);
            }
        }
    }

    public String toString() {
        return "Insumo(" + this.getInsumo() + ")";
    }
}
