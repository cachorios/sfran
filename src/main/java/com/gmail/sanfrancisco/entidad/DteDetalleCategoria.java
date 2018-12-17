package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class DteDetalleCategoria extends AbstractEntidad {

    @ManyToOne
    private Dte dte;

    @ManyToOne
    private Productor productor;

    @ManyToOne
    private Renspa renspa;

    @NotNull
    @ManyToOne
    private Parametro categoria;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double kgVivo;

    @NotNull
    private Double precioKgVivo;

    @NotNull
    private Double kgCarne;

    @NotNull
    private Double porcentajeComision;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<FaenaCabezera> cabezeraFaenas;

    public Double getSaldoComision() {
        return (kgVivo*precioKgVivo*porcentajeComision)/100;
    }

    public Double getImporte() {
        return kgVivo*precioKgVivo;
    }

    public Dte getDte() {
        return dte;
    }

    public void setDte(Dte dte) {
        this.dte = dte;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    public Renspa getRenspa() {
        return renspa;
    }

    public void setRenspa(Renspa renspa) {
        this.renspa = renspa;
    }

    public Parametro getCategoria() {
        return categoria;
    }

    public void setCategoria(Parametro categoria) {
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

    public Double getKgCarne() {
        return kgCarne;
    }

    public void setKgCarne(Double kgCarne) {
        this.kgCarne = kgCarne;
    }

    public Double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(Double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public List<FaenaCabezera> getCabezeraFaenas() {
        return cabezeraFaenas;
    }

    public void setCabezeraFaenas(List<FaenaCabezera> cabezeraFaenas) {
        this.cabezeraFaenas = cabezeraFaenas;
    }

    @Override
    public String toString() {
        return isNew() ? "Nueva categoria en dte" : "(" + this.getProductor() + " - " + this.getRenspa() + ")";
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
