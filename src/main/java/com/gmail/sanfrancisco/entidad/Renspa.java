package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Renspa extends AbstractEntidad {
    @NotNull
    @Size(min=5, max=50, message="La descripción debe contener entre 5 y 50")
    private String numeroRenspa;

    @ManyToOne
    private Productor productor;

    @Override
    public String toString() {
        return getNumeroRenspa();
    }
}
