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
@EqualsAndHashCode(exclude="insumocostovehiculo")
public class ImpuestoCostoVehiculo extends AbstractEntidad {
    @ManyToOne
    private InsumoCostoVehiculo insumocostovehiculo;

    @NotNull
    @ManyToOne
    private Parametro impuesto;

    @NotNull
    private Double saldo;

    public String toString() {
        return this.getImpuesto().toString();
    }
}
