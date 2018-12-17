package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class NumeroDte extends AbstractEntidad {
    @NotNull
    @Size(min=10, max=10, message="El nro de DTE tiene 9 digitos + 1 de verfificacion 'nnnnnnnnn-n'")
    private String numero;

    private String numeroTropaFiscal;

    @ManyToOne
    private Dte dte;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroTropaFiscal() {
        return numeroTropaFiscal;
    }

    public void setNumeroTropaFiscal(String numeroTropaFiscal) {
        this.numeroTropaFiscal = numeroTropaFiscal;
    }

    public Dte getDte() {
        return dte;
    }

    public void setDte(Dte dte) {
        this.dte = dte;
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo numero de dte" : this.getNumero();
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
