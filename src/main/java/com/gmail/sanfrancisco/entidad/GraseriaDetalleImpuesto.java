package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode(exclude="graseriaDetalleInsumo")
public class GraseriaDetalleImpuesto extends AbstractEntidad {
    @ManyToOne
    private GraseriaDetalleInsumo graseriaDetalleInsumo;

    @ManyToOne
    @NotNull
    private Parametro impuesto;

    @NotNull
    private Double saldo;

    public String toString() {
        return isNew() ? "Nuevo impuesto" : this.getImpuesto().toString();
    }
}
