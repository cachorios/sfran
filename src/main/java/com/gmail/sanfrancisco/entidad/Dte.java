package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Dte extends AbstractEntidad {
    private Localidad origen;

    private Localidad destino;

    private Renspa renspa;

    private Conductor conductor;

    private Movil movil;

    @NotNull
    private Integer cantidad;

    @NotNull
    private long especie;

    @NotNull
    private Integer peso;

    @NotNull
    private Double entrega;

    @NotNull
    private Double total;

    @NotNull
    private Double ajustes;

    @NotNull
    @Size(min=5, max=50, message="El numero de tropa debe contener entre 5 y 50 caracteres.")
    private String numTropa;

    @NotNull
    private Date fechaCarga;

    @NotNull
    private Date fechaVencimiento;

    private Consignatario consignatario;

    private Comisionista comisionista;

    // to do 'usuario'

    private Productor productor;

    @NotNull
    private Double kmSalida;

    @NotNull
    private Double kmLlegada;

    private String domJaula;

    private String titular;

    public Localidad getOrigen() {
        return origen;
    }

    public void setOrigen(Localidad origen) {
        this.origen = origen;
    }

    public Localidad getDestino() {
        return destino;
    }

    public void setDestino(Localidad destino) {
        this.destino = destino;
    }

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

    public Movil getMovil() {
        return movil;
    }

    public void setMovil(Movil movil) {
        this.movil = movil;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public long getEspecie() {
        return especie;
    }

    public void setEspecie(long especie) {
        this.especie = especie;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Double getEntrega() {
        return entrega;
    }

    public void setEntrega(Double entrega) {
        this.entrega = entrega;
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

    public String getNumTropa() {
        return numTropa;
    }

    public void setNumTropa(String numTropa) {
        this.numTropa = numTropa;
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

    public String getDomJaula() {
        return domJaula;
    }

    public void setDomJaula(String domJaula) {
        this.domJaula = domJaula;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
