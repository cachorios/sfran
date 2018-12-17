package com.gmail.sanfrancisco.entidad;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public  class  Dte extends AbstractEntidad {

    @NotNull
    @Size(min=4, max=4, message="El numero de tropa debe contener 4 caracteres.")

    @NotNull
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

    @NotNull
    @ManyToOne
    private Conductor conductor;

    @NotNull
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
    private Double totalComisionista;

    @NotNull
    private Double ajustes;


    /**
     * @Description: Fecha en que cargan el camion
     */
    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaCarga;

    @NotNull
    private Date fechaVencimiento;

    @NotNull
    @ManyToOne
    private Consignatario consignatario;

    @NotNull
    @ManyToOne
    private Comisionista comisionista;

    @NotNull
    private Double kmSalida;

    @NotNull
    private Double kmLlegada;

    @NotNull
    @Size(min=4, max=10, message="La patente de jaula debe contener entre 4 y 10 caracteres.")
    private String patenteJaula;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dte", fetch = FetchType.LAZY)
    private List<NumeroDte> numeros;

    //@NotNull
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dte", fetch = FetchType.LAZY)
    private List<DteDetalleCategoria> categorias;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dte", fetch = FetchType.LAZY)
    private List<DteDetalleInsumo> insumos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dte", fetch = FetchType.LAZY)
    private List<DteDetalleImpuesto> impuestos;

    public Dte() {
        categorias = new ArrayList<>();
        insumos = new ArrayList<>();
        impuestos = new ArrayList<>();
        numeros = new ArrayList<>();
    }

    public String getNumeroTropa() {
        return numeroTropa;
    }

    public void setNumeroTropa(String numeroTropa) {
        this.numeroTropa = numeroTropa;
    }

    public Parametro getProvinciaOrigen() {
        return provinciaOrigen;
    }

    public void setProvinciaOrigen(Parametro provinciaOrigen) {
        this.provinciaOrigen = provinciaOrigen;
    }

    public Parametro getLocalidadOrigen() {
        return localidadOrigen;
    }

    public void setLocalidadOrigen(Parametro localidadOrigen) {
        this.localidadOrigen = localidadOrigen;
    }

    public Parametro getProvinciaDestino() {
        return provinciaDestino;
    }

    public void setProvinciaDestino(Parametro provinciaDestino) {
        this.provinciaDestino = provinciaDestino;
    }

    public Parametro getLocalidadDestino() {
        return localidadDestino;
    }

    public void setLocalidadDestino(Parametro localidadDestino) {
        this.localidadDestino = localidadDestino;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Parametro getEspecie() {
        return especie;
    }

    public void setEspecie(Parametro especie) {
        this.especie = especie;
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

    public Double getTotalComisionista() {
        return totalComisionista;
    }

    public void setTotalComisionista(Double totalComisionista) {
        this.totalComisionista = totalComisionista;
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

    public String getPatenteJaula() {
        return patenteJaula;
    }

    public void setPatenteJaula(String patenteJaula) {
        this.patenteJaula = patenteJaula;
    }

    public List<NumeroDte> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<NumeroDte> numeros) {
        this.numeros = numeros;
    }

    public List<DteDetalleCategoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<DteDetalleCategoria> categorias) {
        this.categorias = categorias;
    }

    public List<DteDetalleInsumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<DteDetalleInsumo> insumos) {
        this.insumos = insumos;
    }

    public List<DteDetalleImpuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<DteDetalleImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @Override
    public String toString() {
        return isNew() ? "Nuevo DTE" : this.getNumeroTropa();
    }



    @PrePersist
    @PreUpdate
    public void preUpdate(){
        for(DteDetalleCategoria cat: categorias){
            if(cat.getDte() == null){
                cat.setDte(this);
            }
        }
        for(DteDetalleInsumo ins: insumos){
            if(ins.getDte() == null){
                ins.setDte(this);
            }
        }

        for(DteDetalleImpuesto imp: impuestos){
            if(imp.getDte() == null){
                imp.setDte(this);
            }
        }

        for(NumeroDte num: numeros){
            if(num.getDte() == null){
                num.setDte(this);
            }
        }
    }
}
