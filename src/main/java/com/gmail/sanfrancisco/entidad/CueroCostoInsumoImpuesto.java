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
@EqualsAndHashCode(exclude="cueroCostoInsumo")
public class CueroCostoInsumoImpuesto extends AbstractEntidad {
    @ManyToOne
    private CueroCostoInsumo cueroCostoInsumo;

    @ManyToOne
    @NotNull
    private Parametro impuesto;

    @NotNull
    private Double saldo;

    @Override
    public String toString() {
        return isNew() ? "Nuevo impuesto de insumo en cuero" : this.getImpuesto().toString();
    }
}
