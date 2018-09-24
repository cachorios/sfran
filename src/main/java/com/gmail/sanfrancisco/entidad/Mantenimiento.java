package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Mantenimiento extends AbstractEntidad {
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Movil movil;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Movil getMovil() {
        return movil;
    }

    public void setMovil(Movil movil) {
        this.movil = movil;
    }
}
