package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@EqualsAndHashCode(exclude="productor")
public class Renspa extends AbstractEntidad {
    @NotNull
    @Size(min=5, max=50, message="La descripción debe contener entre 5 y 50")
    private String numeroRenspa;

    @ManyToOne
    private Productor productor;

    @Override
    public String toString() {
        String leyenda = "Nuevo renspa";
        if(!isNew()){
            leyenda = numeroRenspa;
        }
        return leyenda;
    }
}
