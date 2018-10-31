package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class NumeroDte extends AbstractEntidad {
    @NotNull
    @Size(min=11, max=11, message="El nro de DTE tiene 9 digitos + 1 de verfificacion 'nnnnnnnnn-n'")
    private String numero;

    @ManyToOne
    private Dte dte;
}
