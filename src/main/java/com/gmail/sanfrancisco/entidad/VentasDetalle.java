package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class VentasDetalle extends AbstractEntidad {
    @ManyToOne
    private Venta venta;

    @NotNull
    @Size(min=5, max=150, message="La descripción debe tener entre 5 y 150 caracteres.")
    private String descripcion;

    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;
}
