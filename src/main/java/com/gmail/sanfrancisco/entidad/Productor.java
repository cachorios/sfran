package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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

    private String telefono;

    @NotNull
    @Size(min=4, max=150, message="El domicilio debe contener entre 4 y 150 caracteres.")
    private String domicilio;

    private String email;

    @NotNull
    @ManyToOne
    private Parametro condicion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productor", fetch = FetchType.LAZY)
    private List<Renspa> renspas;

    public Productor() {
        renspas = new ArrayList<>();
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

    public List<Renspa> getRenspas() {
        return renspas;
    }

    public void setRenspas(List<Renspa> renspas) {
        this.renspas = renspas;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){
        for(Renspa ren: renspas){
            if(ren.getProductor() == null){
                ren.setProductor(this);
            }
        }
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo Productor" : this.getNombre();
    }
}
