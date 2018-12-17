package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public  class DesposteCostoInsumo extends AbstractEntidad {
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

    public DesposteCosto getDesposteCosto() {
        return desposteCosto;
    }

    public void setDesposteCosto(DesposteCosto desposteCosto) {
        this.desposteCosto = desposteCosto;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setImpuestos(List<DesposteCostoInsumoImpuesto> impuestos) {
        this.impuestos = impuestos;
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
