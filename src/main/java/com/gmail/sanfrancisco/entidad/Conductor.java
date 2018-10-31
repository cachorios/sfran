package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.entidad.Usuario;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public @Data class Conductor extends AbstractEntidad {
    @NotNull
    @Size(min=3, max=60, message="El nombre debe contener entre 3 y 60 caracteres.")
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    private String nombre;

    @NotNull
    @Size(min=11, max=11, message="El cuil debe contener entre 11 caracteres.")
    private String cuil;

    @NotNull
    @Size(min=5, max=11, message="El dni debe contener entre 5 y 11 caracteres.")
    private String dni;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaNacimiento;

    @NotNull
    @Size(min=6, max=20, message="El telefono debe contener entre 6 y 20 caracteres.")
    private String telefono;

    @NotNull
    @Size(min=6, max=20, message="El celular debe contener entre 6 y 20 caracteres.")
    private String celular;

    @NotNull
    @ManyToOne
    private Parametro operadoraTelefonica;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaIngreso;


    @ManyToOne
    private Usuario usuario;

    @Override
    public String toString() {
        String leyenda = "Nuevo Conductor";
        if(!isNew()){
            leyenda = getNombreCompleto();
        }
        return leyenda;
    }

    public String getNombreCompleto() {
        String leyenda = getNombre();

        return leyenda;
    }
}
