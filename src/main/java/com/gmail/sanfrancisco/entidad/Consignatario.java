package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public @Data class Consignatario extends AbstractEntidad {
    @NotNull
    @Size(min=5, max=50, message="La nombre debe contener entre 5 y 50 caracteres.")
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    private String nombre;

    @NotNull
    @Size(min=11, max=11, message="El cuil debe contener entre 11 caracteres.")
    private String cuil;

    @NotNull
    @Size(min=6, max=20, message="El celular debe contener entre 6 y 20 caracteres.")
    private String celular;

    @NotNull
    @Size(min=6, max=20, message="El telefono debe contener entre 6 y 20 caracteres.")
    private String telefono;

    @NotNull
    @Size(min=4, max=150, message="El domicilio debe contener entre 4 y 150 caracteres.")
    private String domicilio;

    @NotNull
    @Size(min=10, max=50, message="El correo electronico debe contener entre 10 y 50 caracteres.")
    private String email;

    public String toString() {
        return getNombre();
    }
}
