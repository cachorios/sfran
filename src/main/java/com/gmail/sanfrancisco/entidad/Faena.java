package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Faena extends AbstractEntidad {
    @NotNull
    private Date fecha;

    @NotNull
    private Integer numero;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faena", fetch = FetchType.LAZY)
//    private List<FaenaProductor> faenaProductor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private FaenaProductor faenaProductor;

    public Faena() {

    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public FaenaProductor getFaenaProductor() {
        return faenaProductor;
    }

    public void setFaenaProductor(FaenaProductor faenaProductor) {
        this.faenaProductor = faenaProductor;
    }

    public String toString() {
        return isNew() ? "Nueva Faena" : this.getFecha().toString();
    }

    @PrePersist
//    @PreUpdate
    public void preUpdate(){
        System.out.printf( this.toString());
        return;

    }
}
