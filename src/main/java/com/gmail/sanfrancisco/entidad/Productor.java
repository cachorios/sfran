package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Productor extends AbstractEntidad {
    @NotNull
    @Size(min=5, max=50, message="La nombre debe contener entre 5 y 50 caracteres.")
    private String nombre;

    @NotNull
    @Size(min=5, max=20, message="El cuil debe contener entre 5 y 20 caracteres.")
    private String cuil;

    @NotNull
    @Size(min=6, max=20, message="El celular debe contener entre 6 y 20 caracteres.")
    private String celular;

    @NotNull
    @Size(min=6, max=20, message="El telefono debe contener entre 6 y 20 caracteres.")
    private String telefono;

    @NotNull
    @Size(min=4, max=150, message="El domicilio debe contener entre 4 y 150 caracteres.")
    private String domicilio;

    @NotNull
    @Size(min=10, max=50, message="El correo electronico debe contener entre 10 y 50 caracteres.")
    private String email;

    @NotNull
    @ManyToOne
    private Parametro condicion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Parametro getCondicion() {
        return condicion;
    }

    public void setCondicion(Parametro condicion) {
        this.condicion = condicion;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
