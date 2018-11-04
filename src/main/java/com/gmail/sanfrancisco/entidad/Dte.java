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

    @ManyToOne
    private Consignatario consignatario;

    @ManyToOne
    private Comisionista comisionista;

    @NotNull
    private Double kmSalida;

    @NotNull
    private Double kmLlegada;

    private String patenteJaula;

    private String titular;

    //@NotNull
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dte", fetch = FetchType.LAZY)
    private List<DteDetalleCategoria> categorias;

    public Dte() {
        categorias = new ArrayList<>();
    }

    public String toString() {
        return "DTE(" + this.getNumeroTropa() + ")";
    }
}
