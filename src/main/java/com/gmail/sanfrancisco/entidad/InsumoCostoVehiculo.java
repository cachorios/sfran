package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class InsumoCostoVehiculo extends AbstractEntidad {
    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;

    @ManyToOne
    private FacturaCostoVehiculo facturaCostoVehiculo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumocostovehiculo", fetch = FetchType.LAZY)
    private List<ImpuestoCostoVehiculo> impuestos;

    public InsumoCostoVehiculo() {
        impuestos = new ArrayList<>();
    }

    public String toString() {
        return this.getInsumo().toString();
    }

    public List<ImpuestoCostoVehiculo> getImpuestos() {
        return impuestos;
    }

    public void setInsumos(List<ImpuestoCostoVehiculo> impuestos) {
        this.impuestos = impuestos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){
        for(ImpuestoCostoVehiculo imp: impuestos){
            if(imp.getInsumocostovehiculo() == null){
                imp.setInsumocostovehiculo(this);
            }
        }
    }
}
