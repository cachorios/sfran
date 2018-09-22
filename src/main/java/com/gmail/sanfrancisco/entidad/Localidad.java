package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Localidad extends AbstractEntidad {
    @NotNull
    @Size(min=5, max=100, message="El nombre debe contener entre 5 y 100 caracteres.")
    private String nombre;

    @NotNull
    @Size(min=3, max=20, message="El codigo postal debe contener entre 3 y 20 caracteres.")
    private String cp;

    @NotNull
    private long provincia;

    // to do: idProvincia

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public long getProvincia() {
        return provincia;
    }

    public void setProvincia(long provincia) {
        this.provincia = provincia;
    }
}
