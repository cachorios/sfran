package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;



@Entity
public class Dte extends AbstractEntidad {

    @NotNull
    @Size(min=4, max=4, message="El numero de tropa debe contener 4 caracteres.")
    private String numeroTropa;

    @NotNull
    @ManyToOne
    private Parametro provinciaOrigen;

    @NotNull
    @ManyToOne
    private Parametro localidadOrigen;

    @NotNull
    @ManyToOne
    private Parametro provinciaDestino;

    @NotNull
    @ManyToOne
    private Parametro localidadDestino;

    @ManyToOne
    private Renspa renspa;

    @ManyToOne
    private Conductor conductor;

    @ManyToOne
    private Vehiculo vehiculo;

    @NotNull
    private Integer cantidad;

    @NotNull
    @ManyToOne
    private Parametro especie;

    @NotNull
    private Integer peso;

    @NotNull
    private Double importeEntrega;

    @NotNull
    private Double total;

    @NotNull
    private Double ajustes;


    /**
     * @Description: Fecha en que cargan el camion
     */
    @NotNull
    private Date fechaCarga;

    @NotNull
    private Date fechaVencimiento;

    @ManyToOne
    private Consignatario consignatario;

    @ManyToOne
    private Comisionista comisionista;


    @ManyToOne
    private Productor productor;

    @NotNull
    private Double kmSalida;

    @NotNull
    private Double kmLlegada;

    private String patenteJaula;

    private String titular;


    public Renspa getRenspa() {
        return renspa;
    }

    public void setRenspa(Renspa renspa) {
        this.renspa = renspa;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getNumeroTropa() {
        return numeroTropa;
    }

    public void setNumeroTropa(String numeroTropa) {
        this.numeroTropa = numeroTropa;
    }

    public Consignatario getConsignatario() {
        return consignatario;
    }

    public void setConsignatario(Consignatario consignatario) {
        this.consignatario = consignatario;
    }

    public Comisionista getComisionista() {
        return comisionista;
    }

    public void setComisionista(Comisionista comisionista) {
        this.comisionista = comisionista;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    public String getPatenteJaula() {
        return patenteJaula;
    }

    public void setPatenteJaula(String patenteJaula) {
        this.patenteJaula = patenteJaula;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Double getImporteEntrega() {
        return importeEntrega;
    }

    public void setImporteEntrega(Double importeEntrega) {
        this.importeEntrega = importeEntrega;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getAjustes() {
        return ajustes;
    }

    public void setAjustes(Double ajustes) {
        this.ajustes = ajustes;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getKmSalida() {
        return kmSalida;
    }

    public void setKmSalida(Double kmSalida) {
        this.kmSalida = kmSalida;
    }

    public Double getKmLlegada() {
        return kmLlegada;
    }

    public void setKmLlegada(Double kmLlegada) {
        this.kmLlegada = kmLlegada;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Parametro getLocalidadOrigen() {
        return localidadOrigen;
    }

    public void setLocalidadOrigen(Parametro localidadOrigen) {
        this.localidadOrigen = localidadOrigen;
    }

    public Parametro getLocalidadDestino() {
        return localidadDestino;
    }

    public void setLocalidadDestino(Parametro localidadDestino) {
        this.localidadDestino = localidadDestino;
    }

    public Parametro getProvinciaOrigen() {
        return provinciaOrigen;
    }

    public void setProvinciaOrigen(Parametro provinciaOrigen) {
        this.provinciaOrigen = provinciaOrigen;
    }

    public Parametro getProvinciaDestino() {
        return provinciaDestino;
    }

    public void setProvinciaDestino(Parametro provinciaDestino) {
        this.provinciaDestino = provinciaDestino;
    }

    public Parametro getEspecie() {
        return especie;
    }

    public void setEspecie(Parametro especie) {
        this.especie = especie;
    }


}
