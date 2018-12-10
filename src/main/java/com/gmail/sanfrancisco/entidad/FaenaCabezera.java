package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class FaenaCabezera extends AbstractEntidad {
    @NotNull
    @ManyToOne
    private DteDetalleCategoria categoria;

    @NotNull
    private Integer cantidad;

    @Override
    public String toString() { return  isNew() ? "Nueva Faena Cabezera" : this.categoria.toString(); }
}
