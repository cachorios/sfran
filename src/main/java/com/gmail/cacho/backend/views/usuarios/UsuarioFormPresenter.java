package com.gmail.cacho.backend.views.usuarios;

import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.service.UsuarioServicio;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;

import javax.inject.Inject;

public class UsuarioFormPresenter extends AbstractPresenterForm<Usuario, UsuarioServicio> {
    @Inject
    public UsuarioFormPresenter(UsuarioServicio servicio) {
        super(servicio);
    }
}
