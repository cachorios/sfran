package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode(exclude="cueroCosto")
public @Data class CueroCostoInsumo extends AbstractEntidad {
    @ManyToOne
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    private CueroCosto cueroCosto;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cueroCostoInsumo", fetch = FetchType.LAZY)
    private List<CueroCostoInsumoImpuesto> impuestos;

    public CueroCostoInsumo() {
        impuestos = new ArrayList<>();
    }

    public List<CueroCostoInsumoImpuesto> getImpuestos() {
        return impuestos;
    }

    public void setInsumos(List<CueroCostoInsumoImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(CueroCostoInsumoImpuesto imp: impuestos){
            if(imp.getCueroCostoInsumo() == null){
                imp.setCueroCostoInsumo(this);
            }
        }
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo insumo en costo de cuero" : this.getInsumo().toString();
    }
}
