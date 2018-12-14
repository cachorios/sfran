package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude="faenaProductor")
public class FaenaCabezera extends AbstractEntidad {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private DteDetalleCategoria categoria;

    @NotNull
    private Integer cantidad;

    @Transient
    private Integer faenado;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FaenaProductor faenaProductor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faenaCabezera", fetch = FetchType.LAZY)
    private List<FaenaDetalle> faenaDetalle;


    public FaenaCabezera() {
        faenado = 0;
        faenaDetalle = new ArrayList<>();
    }

    @Override
    public String toString() { return  isNew() ? "Nueva Faena Cabezera" : this.categoria.toString(); }

    @PrePersist
    @PreUpdate
    public void preUpdate(){
        return;

    }
}
