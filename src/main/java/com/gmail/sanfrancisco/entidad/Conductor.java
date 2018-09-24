package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
    @Size(min=11, max=11, message="El cuil debe contener entre 11 caracteres.")
    private String cuil;

    @NotNull
    @Size(min=5, max=11, message="El dni debe contener entre 5 y 11 caracteres.")
    private String dni;

    @NotNull
    private Date fechaNacimiento;

    @NotNull
    @Size(min=6, max=20, message="El telefono debe contener entre 6 y 20 caracteres.")
    private String telefono;

    @NotNull
    @Size(min=6, max=20, message="El celular debe contener entre 6 y 20 caracteres.")
    private String celular;

    @NotNull
    private Date fechaIngreso;

    @NotNull
    private long operadoraTelefonica;

    @ManyToOne
    private Usuario usuario;


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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getOperadoraTelefonica() {
        return operadoraTelefonica;
    }

    public void setOperadoraTelefonica(long operadoraTelefonica) {
        this.operadoraTelefonica = operadoraTelefonica;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
