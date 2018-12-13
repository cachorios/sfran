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
@EqualsAndHashCode(exclude="vehiculoCosto")
public class VehiculoCostoInsumo extends AbstractEntidad {
    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Double cantidad;

    @NotNull
    private Double precio;

    @ManyToOne
    private VehiculoCosto vehiculoCosto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoCostoInsumo", fetch = FetchType.LAZY)
    private List<VehiculoCostoInsumoImpuesto> impuestos;

    public VehiculoCostoInsumo() {
        impuestos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo insumo en costo de vehiculo" : this.getInsumo().toString();
    }

    public List<VehiculoCostoInsumoImpuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<VehiculoCostoInsumoImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){
        for(VehiculoCostoInsumoImpuesto imp: impuestos){
            if(imp.getVehiculoCostoInsumo() == null){
                imp.setVehiculoCostoInsumo(this);
            }
        }
    }
}
