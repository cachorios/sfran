package com.gmail.sanfrancisco.entidad;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CondicionIva {
    @NotNull
    @Size(min=5, max=50, message="La descripción debe contener entre 5 y 50 caracteres.")
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
