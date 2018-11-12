package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity


@Data
@EqualsAndHashCode(exclude="dte")
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

    public Double getSaldoComision() {
        return (kgVivo*precioKgVivo*porcentajeComision)/100;
    }

    @Override
    public String toString() {
        return "(" + productor +
                ", " + renspa +
                '}';
    }
}
