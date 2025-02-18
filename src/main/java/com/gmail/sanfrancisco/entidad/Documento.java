package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;


import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public  class Documento extends AbstractEntidad {
    @NotNull
    @Size(min=12, max=100, message="El nombre de archivo debe contener entre 12 y 100 caracteres.")
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    private String nombreArchivo;

    @NotNull
    @Size(min=5, max=100, message="La descripción debe contener entre 5 y 100 caracteres.")
    private String descripcion;


    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        return getDescripcion();
    }

    @Override
    @PrePersist
    protected void setAltaData() {
        super.setAltaData();
    }

    @Override
    @PreUpdate
    protected void setUmodData() {
        super.setUmodData();
    }
}
