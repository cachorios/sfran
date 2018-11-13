package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
public  @Data class  Dte extends AbstractEntidad {

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
    }

    public String toString() {
        return "DTE(" + this.getNumeroTropa() + ")";
    }

    public List<DteDetalleCategoria> getCategorias() {
        return categorias;
    }

    public List<DteDetalleInsumo> getInsumos() {
        return insumos;
    }

    public List<DteDetalleImpuesto> getImpuestos() {
        return impuestos;
    }

    public void setCategorias(List<DteDetalleCategoria> categorias) {
        this.categorias = categorias;
    }
    public void setInsumos(List<DteDetalleInsumo> insumos) {
        this.insumos = insumos;
    }
    public void setImpuestos(List<DteDetalleImpuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){
        for(DteDetalleCategoria cat: categorias){
            if(cat.getDte() == null){
                cat.setDte(this);
            }
        }
    }
}
