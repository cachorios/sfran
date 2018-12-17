package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity

public class Licencia extends AbstractEntidad {

    @NotNull
    @ManyToOne
    private Parametro tipoLicencia;

    private Date vencimiento;

    private Date vencimientoNac;

    private Date vencimientoCurso;

    @NotNull
    private Boolean licenciaCarga;

    @ManyToOne
    private Conductor conductor;

    public Parametro getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(Parametro tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Date getVencimientoNac() {
        return vencimientoNac;
    }

    public void setVencimientoNac(Date vencimientoNac) {
        this.vencimientoNac = vencimientoNac;
    }

    public Date getVencimientoCurso() {
        return vencimientoCurso;
    }

    public void setVencimientoCurso(Date vencimientoCurso) {
        this.vencimientoCurso = vencimientoCurso;
    }

    public Boolean getLicenciaCarga() {
        return licenciaCarga;
    }

    public void setLicenciaCarga(Boolean licenciaCarga) {
        this.licenciaCarga = licenciaCarga;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    @Override
    public String toString() {
        String leyenda = "Nueva Licencia";
        if(!isNew()){
            leyenda = "(" + tipoLicencia + ": " + vencimiento + ")";
        }
        return leyenda;
    }
}
