package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class FaenaProductor extends AbstractEntidad {
    @NotNull
    @ManyToOne
    private Productor productor;

    @NotNull
    private String tropa;

    @Override
    public String toString() { return isNew() ? "Nuevo Faena-Productor" : this.productor.toString(); }
}
