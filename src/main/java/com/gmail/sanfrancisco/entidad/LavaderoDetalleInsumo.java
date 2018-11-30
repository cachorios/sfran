package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode(exclude="lavadero")
public class LavaderoDetalleInsumo extends AbstractEntidad {
    @ManyToOne
    private Lavadero lavadero;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;
}
