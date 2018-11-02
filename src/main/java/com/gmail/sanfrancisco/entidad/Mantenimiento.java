package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Mantenimiento extends AbstractEntidad {
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Vehiculo vehiculo;
}
