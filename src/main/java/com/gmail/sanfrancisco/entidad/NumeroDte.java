package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class NumeroDte extends AbstractEntidad {
    @NotNull
    @Size(min=11, max=11, message="El nro de DTE tiene 9 digiyo + 1 de verfificacion 'nnnnnnnnn-n'")
    private String numero;

    @ManyToOne
    private Dte dte;

    public Dte getDte() {
        return dte;
    }

    public void setDte(Dte dte) {
        this.dte = dte;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
