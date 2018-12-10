package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude="faenaProductor")
public class FaenaCabezera extends AbstractEntidad {
    @NotNull
    @ManyToOne
    private DteDetalleCategoria categoria;

    @NotNull
    private Integer cantidad;

    @ManyToOne
    private FaenaProductor faenaProductor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faenaCabezera", fetch = FetchType.LAZY)
    private List<FaenaDetalle> faenaDetalle;

    @Override
    public String toString() { return  isNew() ? "Nueva Faena Cabezera" : this.categoria.toString(); }
}
