package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Renspa extends AbstractEntidad {
    @NotNull
    @Size(min=5, max=50, message="La descripción debe contener entre 5 y 50")
    private String numeroRenspa;

    @ManyToOne
    private Productor productor;

    public String getNumeroRenspa() {
        return numeroRenspa;
    }

    public void setNumeroRenspa(String numeroRenspa) {
        this.numeroRenspa = numeroRenspa;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo numero de renspa" : this.getNumeroRenspa();
    }
}
