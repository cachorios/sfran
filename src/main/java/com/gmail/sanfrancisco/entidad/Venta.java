package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Venta extends AbstractEntidad {

    @ManyToOne
    private Usuario usuario;

    public String toString() {
        return this.getUsuario().toString();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.LAZY)
    private List<VentasDetalle> ventas;

    public Venta() {
        ventas = new ArrayList<>();
    }

    public List<VentasDetalle> getVenta() {
        return ventas;
    }

    public void setInsumos(List<VentasDetalle> insumos) {
        this.ventas = insumos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){

        for(VentasDetalle ins: ventas){
            if(ins.getVenta() == null){
                ins.setVenta(this);
            }
        }
    }
}
