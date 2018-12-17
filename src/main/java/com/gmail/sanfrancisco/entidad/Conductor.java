package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.entidad.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public  class Conductor extends AbstractEntidad {
    @NotNull
    @Size(min=3, max=60, message="El nombre debe contener entre 3 y 60 caracteres.")
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    private String nombre;

    @NotNull
    @Size(min=11, max=11, message="El cuil debe contener 11 caracteres.")
    private String cuil;

    @NotNull
    @Size(min=5, max=11, message="El dni debe contener entre 5 y 11 caracteres.")
    private String dni;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaNacimiento;

    private String telefono;

    @NotNull
    @Size(min=6, max=20, message="El celular debe contener entre 6 y 20 caracteres.")
    private String celular;

    @NotNull
    @ManyToOne
    private Parametro operadoraTelefonica;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conductor", fetch = FetchType.LAZY)
    private List<Licencia> licencias;


    @ManyToOne
    private Usuario usuario;

    public Conductor() {
        licencias = new ArrayList<>();
    }

    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public Parametro getOperadoraTelefonica() {
        return operadoraTelefonica;
    }

    public void setOperadoraTelefonica(Parametro operadoraTelefonica) {
        this.operadoraTelefonica = operadoraTelefonica;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Licencia> getLicencias() {
        return licencias;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo Conductor" : this.getNombre();
    }

    @Override
    @PrePersist
    protected void setAltaData() {
        super.setAltaData();

        for(Licencia lic: licencias){
            if(lic.getConductor() == null){
                lic.setConductor(this);
            }
        }
    }

    @Override
    @PreUpdate
    protected void setUmodData() {
        for(Licencia lic: licencias){
            if(lic.getConductor() == null){
                lic.setConductor(this);
            }
        }

        super.setUmodData();
    }
}
