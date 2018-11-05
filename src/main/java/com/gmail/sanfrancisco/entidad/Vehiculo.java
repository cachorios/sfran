package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public @Data class Vehiculo extends AbstractEntidad {

    @NotNull
    @Size(min=3, max=50, message="El dominio debe contener entre 3 y 50 caracteres.")
    private String dominio;

    @NotNull(message = "El año es obligatorio")
    private Integer anio;

    @NotNull
    @ManyToOne
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
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

    @Override
    public String toString() {
        return isNew() ? "Nuevo Vehiculo" : this.getDominio();
    }
}
