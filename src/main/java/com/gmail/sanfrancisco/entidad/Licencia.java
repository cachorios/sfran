package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Licencia extends AbstractEntidad {

    @NotNull
    @ManyToOne
    private Parametro tipoLicencia;

    @NotNull
    private Date vencimiento;

    @NotNull
    private Date vencimientoNac;

    @NotNull
    private Date vencimientoCurso;

    @NotNull
    private Boolean licenciaCarga;

    @ManyToOne
    private Conductor conductor;
}
