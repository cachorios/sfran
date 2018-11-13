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
@EqualsAndHashCode(exclude="dte")
public class DteDetalleImpuesto extends AbstractEntidad {
    @ManyToOne
    private Dte dte;

    @NotNull
    @ManyToOne
    private Parametro impuesto;

    @NotNull
    private Double saldo;

    @Override
    public String toString() {
        return impuesto==null ? "Nuevo Det. Imp." : impuesto.toString();
    }
}
