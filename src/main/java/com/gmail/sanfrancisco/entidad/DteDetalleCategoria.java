package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class DteDetalleCategoria extends AbstractEntidad {
    @ManyToOne
    private Dte dte;

    @ManyToOne
    private long categoria;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double kgVivo;

    @NotNull
    private Double precioKgVivo;

    @NotNull
    private Double saldoComision;

    @NotNull
    private Double kgCarne;

    @NotNull
    private Double rendimiento;

    @NotNull
    private Double porcentajeComision;

    public Dte getDte() {
        return dte;
    }

    public void setDte(Dte dte) {
        this.dte = dte;
    }

    public long getCategoria() {
        return categoria;
    }

    public void setCategoria(long categoria) {
        this.categoria = categoria;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getKgVivo() {
        return kgVivo;
    }

    public void setKgVivo(Double kgVivo) {
        this.kgVivo = kgVivo;
    }

    public Double getPrecioKgVivo() {
        return precioKgVivo;
    }

    public void setPrecioKgVivo(Double precioKgVivo) {
        this.precioKgVivo = precioKgVivo;
    }

    public Double getSaldoComision() {
        return saldoComision;
    }

    public void setSaldoComision(Double saldoComision) {
        this.saldoComision = saldoComision;
    }

    public Double getKgCarne() {
        return kgCarne;
    }

    public void setKgCarne(Double kgCarne) {
        this.kgCarne = kgCarne;
    }

    public Double getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(Double rendimiento) {
        this.rendimiento = rendimiento;
    }

    public Double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(Double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }
}
