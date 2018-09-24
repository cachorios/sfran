package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Viscera extends AbstractEntidad {
    @ManyToOne
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
