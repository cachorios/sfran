package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Licencia extends AbstractEntidad {
    @ManyToOne
    private long tipoLicencia;

    @NotNull
    private Date vencimiento;

    @NotNull
    private Date vencimientoNac;

    @NotNull
    private Date vencimientoCurso;

    @NotNull
    private Boolean licenciaCarga;

    // to do 'conductor'


    public long getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(long tipoLicencia) {
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
}
