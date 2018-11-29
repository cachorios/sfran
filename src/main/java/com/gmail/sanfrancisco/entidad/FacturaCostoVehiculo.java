package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class FacturaCostoVehiculo extends AbstractEntidad {
    @NotNull
    private Date fecha;

    @ManyToOne
    private Vehiculo vehiculo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCostoVehiculo", fetch = FetchType.LAZY)
    private List<InsumoCostoVehiculo> insumos;

    public FacturaCostoVehiculo() {
        insumos = new ArrayList<>();
    }

    public String toString() {
        return this.getFecha().toString();
    }

    public List<InsumoCostoVehiculo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<InsumoCostoVehiculo> insumos) {
        this.insumos = insumos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){
        for(InsumoCostoVehiculo ins: insumos){
            if(ins.getFacturaCostoVehiculo() == null){
                ins.setFacturaCostoVehiculo(this);
            }
        }
    }
}
