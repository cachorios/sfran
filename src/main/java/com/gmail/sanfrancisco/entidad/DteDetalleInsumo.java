package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode(exclude="dte")
public class DteDetalleInsumo extends AbstractEntidad {
    @ManyToOne
    private Dte dte;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;

    public Double getImporte() {
        return cantidad*precio;
    }

    @Override
    public String toString() {
        return insumo == null ? "Nuevo Det.Insumo" : insumo.toString()+"("+ cantidad.toString() +")";
    }
}
