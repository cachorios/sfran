package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode(exclude="desposteCosto")
public @Data class DesposteCostoInsumo extends AbstractEntidad {
    @ManyToOne
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    private DesposteCosto desposteCosto;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desposteCostoInsumo", fetch = FetchType.LAZY)
    private List<DesposteCostoInsumoImpuesto> impuestos;

    public DesposteCostoInsumo() {
        impuestos = new ArrayList<>();
    }

    public List<DesposteCostoInsumoImpuesto> getImpuestos() {
        return impuestos;
    }

    public void setInsumos(List<DesposteCostoInsumoImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(DesposteCostoInsumoImpuesto imp: impuestos){
            if(imp.getDesposteCostoInsumo() == null){
                imp.setDesposteCostoInsumo(this);
            }
        }
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo insumo en costo de desposte" : this.getInsumo().toString();
    }
}
