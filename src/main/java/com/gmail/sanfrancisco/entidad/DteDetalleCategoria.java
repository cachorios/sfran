package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
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

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<FaenaCabezera> cabezeraFaenas;

    public Double getSaldoComision() {
        return (kgVivo*precioKgVivo*porcentajeComision)/100;
    }

    public Double getImporte() {
        return kgVivo*precioKgVivo;
    }

    @Override
    public String toString() {
        return isNew() ? "Nueva categoria en dte" : "(" + this.getProductor() + " - " + this.getRenspa() + ")";
    }


}
