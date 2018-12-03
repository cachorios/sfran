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
@EqualsAndHashCode(exclude="graseriaCosto")
public class GraseriaCostoInsumo extends AbstractEntidad {
    @ManyToOne
    private GraseriaCosto graseriaCosto;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "graseriaCostoInsumo", fetch = FetchType.LAZY)
    private List<GraseriaCostoInsumoImpuesto> impuestos;

    public GraseriaCostoInsumo() {
        impuestos = new ArrayList<>();
    }

    public List<GraseriaCostoInsumoImpuesto> getImpuestos() {
        return impuestos;
    }

    public void setInsumos(List<GraseriaCostoInsumoImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(GraseriaCostoInsumoImpuesto imp: impuestos){
            if(imp.getGraseriaCostoInsumo() == null){
                imp.setGraseriaCostoInsumo(this);
            }
        }
    }

    public String toString() {
        return isNew() ? "Nuevo insumo" : this.getInsumo().toString();
    }
}
