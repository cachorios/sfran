package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Movil extends AbstractEntidad {
    @NotNull
    @Size(min=3, max=100, message="La descripción debe contener entre 3 y 100 caracteres.")
    private String descripcion;

    @NotNull
    @Size(min=3, max=100, message="El modelo debe contener entre 3 y 100 caracteres.")
    private String modelo;

    @NotNull
    @Size(min=3, max=50, message="El dominio debe contener entre 3 y 50 caracteres.")
    private String dominio;

    @NotNull
    private long tipoCombustible;

    @NotNull
    private long color;

    private Integer maxCabezas;

    private Double tara;

    private Double cargaMax;

    private Double consumo;

    private Double alto;

    private Double largo;

    private Double ancho;

    private Double volumen;

    @NotNull
    @Size(min=5, max=60, message="El numero de motor debe contener entre 5 y 60 caracteres.")
    private String numeroMotor;

    @NotNull
    @Size(min=5, max=60, message="El numero de chasis debe contener entre 5 y 60 caracteres.")
    private String numeroChasis;

    @ManyToOne
    private Marca marca;

    @NotNull
    private Date anno;

    private long estadoMovil;

    @NotNull
    private Date fecha;

    public long getEstadoMovil() {
        return estadoMovil;
    }

    public void setEstadoMovil(long estadoMovil) {
        this.estadoMovil = estadoMovil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public long getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(long tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public long getColor() {
        return color;
    }

    public void setColor(long color) {
        this.color = color;
    }

    public Integer getMaxCabezas() {
        return maxCabezas;
    }

    public void setMaxCabezas(Integer maxCabezas) {
        this.maxCabezas = maxCabezas;
    }

    public Double getTara() {
        return tara;
    }

    public void setTara(Double tara) {
        this.tara = tara;
    }

    public Double getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(Double cargaMax) {
        this.cargaMax = cargaMax;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Date getAnno() {
        return anno;
    }

    public void setAnno(Date anno) {
        this.anno = anno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
