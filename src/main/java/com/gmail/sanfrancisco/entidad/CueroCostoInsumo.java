package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public  class CueroCostoInsumo extends AbstractEntidad {
    @ManyToOne
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    private CueroCosto cueroCosto;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Double cantidad;

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


    public CueroCosto getCueroCosto() {
        return cueroCosto;
    }

    public void setCueroCosto(CueroCosto cueroCosto) {
        this.cueroCosto = cueroCosto;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setImpuestos(List<CueroCostoInsumoImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    public void setInsumos(List<CueroCostoInsumoImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo insumo en costo de cuero" : this.getInsumo().toString();
    }

    @Override
    @PrePersist
    protected void setAltaData() {
        super.setAltaData();
        for(CueroCostoInsumoImpuesto imp: impuestos){
            if(imp.getCueroCostoInsumo() == null){
                imp.setCueroCostoInsumo(this);
            }
        }
    }

    @Override
    @PreUpdate
    protected void setUmodData() {
        super.setUmodData();
        for(CueroCostoInsumoImpuesto imp: impuestos){
            if(imp.getCueroCostoInsumo() == null){
                imp.setCueroCostoInsumo(this);
            }
        }
    }
}
