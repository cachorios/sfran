package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Vehiculo extends AbstractEntidad {

    @NotNull
    @Size(min=3, max=50, message="El dominio debe contener entre 3 y 50 caracteres.")
    private String dominio;

    @NotNull(message = "El año es obligatorio")
    private Integer anio;

    @NotNull
    @ManyToOne
    private Parametro tipoVehiculo;

    @NotNull
    @ManyToOne
    private Parametro marca;

    @NotNull
    @Size(min=3, max=100, message="El modelo debe contener entre 3 y 100 caracteres.")
    private String modelo;

    @NotNull
    @Size(min=5, max=60, message="El numero de motor debe contener entre 5 y 60 caracteres.")
    private String numeroMotor;

    @NotNull
    @Size(min=5, max=60, message="El numero de chasis debe contener entre 5 y 60 caracteres.")
    private String numeroChasis;

    @NotNull
    @ManyToOne
    private Parametro color;

    @NotNull
    private Double tara;
    @NotNull
    private Double alto;
    @NotNull
    private Double largo;
    @NotNull
    private Double ancho;
    @NotNull
    private Integer maxCabezas;
    @NotNull
    private Double cargaMax;

    @NotNull
    @ManyToOne
    private Parametro tipoCombustible;

    @NotNull
    private Double consumoCombustible;

    @NotNull
    @ManyToOne
    private Parametro estadoVehiculo;

    @NotNull
    private Date fecha;

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Parametro getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(Parametro tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Parametro getMarca() {
        return marca;
    }

    public void setMarca(Parametro marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public Parametro getColor() {
        return color;
    }

    public void setColor(Parametro color) {
        this.color = color;
    }

    public Double getTara() {
        return tara;
    }

    public void setTara(Double tara) {
        this.tara = tara;
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

    public Integer getMaxCabezas() {
        return maxCabezas;
    }

    public void setMaxCabezas(Integer maxCabezas) {
        this.maxCabezas = maxCabezas;
    }

    public Double getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(Double cargaMax) {
        this.cargaMax = cargaMax;
    }

    public Parametro getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(Parametro tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public Double getConsumoCombustible() {
        return consumoCombustible;
    }

    public void setConsumoCombustible(Double consumoCombustible) {
        this.consumoCombustible = consumoCombustible;
    }

    public Parametro getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(Parametro estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo Vehiculo" : this.getDominio();
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
