package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Conductor extends AbstractEntidad {
    @NotNull
    @Size(min=3, max=60, message="El nombre debe contener entre 3 y 60 caracteres.")
    private String nombre;

    @NotNull
    @Size(min=3, max=60, message="El apellido debe contener entre 3 y 60 caracteres.")
    private String apellido;

    @NotNull
    @Size(min=5, max=20, message="El cuil debe contener entre 5 y 20 caracteres.")
    private String cuil;

    @NotNull
    @Size(min=5, max=20, message="El dni debe contener entre 5 y 20 caracteres.")
    private String dni;

    @NotNull
    private Date fechaNac;

    @NotNull
    @Size(min=6, max=20, message="El telefono debe contener entre 6 y 20 caracteres.")
    private String telefono;

    @NotNull
    @Size(min=6, max=20, message="El celular debe contener entre 6 y 20 caracteres.")
    private String celular;

    @NotNull
    private Date fechaIngreso;

    @NotNull
    private long operadora;

    // to do 'usuario'


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public long getOperadora() {
        return operadora;
    }

    public void setOperadora(long operadora) {
        this.operadora = operadora;
    }
}
