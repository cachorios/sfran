package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Dte extends AbstractEntidad {

    @NotNull
    private long origen;

    @NotNull
    private long destino;

    @ManyToOne
    private Renspa renspa;

    @ManyToOne
    private Conductor conductor;

    @ManyToOne
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
    private String numeroTropa;

    @NotNull
    private Date fechaCarga;

    @NotNull
    private Date fechaVencimiento;

    @ManyToOne
    private Consignatario consignatario;

    @ManyToOne
    private Comisionista comisionista;

//     to do 'usuario'

    @ManyToOne
    private Productor productor;

    @NotNull
    private Double kmSalida;

    @NotNull
    private Double kmLlegada;

    private String patenteJaula;

    private String titular;



    public long getOrigen() {
        return origen;
    }

    public void setOrigen(long origen) {
        this.origen = origen;
    }

    public long getDestino() {
        return destino;
    }

    public void setDestino(long destino) {
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
}
