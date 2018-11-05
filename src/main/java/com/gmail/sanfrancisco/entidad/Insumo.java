package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public @Data class Insumo extends AbstractEntidad {
    @NotNull
    @Size(min=3, max=100, message="La descripción debe contener entre 3 y 100 caracteres.")
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    private String descripcion;

    @NotNull
    @ManyToOne
    private Parametro tipoInsumo;

    @NotNull
    @ManyToOne
    private Parametro unidadMedida;

    @Override
    public String toString() {
        return getDescripcion();
    }
}
