package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Comision extends AbstractEntidad {
    @NotNull
    private Double porcentaje;

    @ManyToOne
    private Insumo insumo;

    // todo 'VentasDetalle'
}
