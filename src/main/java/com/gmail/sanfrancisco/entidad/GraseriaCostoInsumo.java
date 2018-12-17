package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GraseriaCostoInsumo extends AbstractEntidad {
    @ManyToOne
    private GraseriaCosto graseriaCosto;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Double cantidad;

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

    public GraseriaCosto getGraseriaCosto() {
        return graseriaCosto;
    }

    public void setGraseriaCosto(GraseriaCosto graseriaCosto) {
        this.graseriaCosto = graseriaCosto;
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

    public void setImpuestos(List<GraseriaCostoInsumoImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo insumo en costo de graseria" : this.getInsumo().toString();
    }

    @Override
    @PrePersist
    protected void setAltaData() {
        super.setAltaData();
        for(GraseriaCostoInsumoImpuesto imp: impuestos){
            if(imp.getGraseriaCostoInsumo() == null){
                imp.setGraseriaCostoInsumo(this);
            }
        }
    }

    @Override
    @PreUpdate
    protected void setUmodData() {
        super.setUmodData();
        for(GraseriaCostoInsumoImpuesto imp: impuestos){
            if(imp.getGraseriaCostoInsumo() == null){
                imp.setGraseriaCostoInsumo(this);
            }
        }
    }
}
