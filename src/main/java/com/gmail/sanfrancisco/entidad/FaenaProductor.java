package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude="faena")
public class FaenaProductor extends AbstractEntidad {
    @NotNull
    @ManyToOne
    private Productor productor;

    @NotNull
    private String tropa;

    @ManyToOne
    private Faena faena;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faenaProductor", fetch = FetchType.LAZY)
    private List<FaenaCabezera> faenaCabezera;

    @Override
    public String toString() { return isNew() ? "Nuevo Faena-Productor" : this.productor.toString(); }
}
