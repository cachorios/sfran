package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@EqualsAndHashCode(exclude="cuero")
public @Data class CueroDetalleInsumo extends AbstractEntidad {
    @ManyToOne
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    private Cuero cuero;

    @ManyToOne
    private Insumo insumo;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;
}
