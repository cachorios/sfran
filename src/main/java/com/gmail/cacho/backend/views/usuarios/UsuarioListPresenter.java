package com.gmail.cacho.backend.views.usuarios;

import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.service.UsuarioServicio;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;

import javax.inject.Inject;

public class UsuarioListPresenter extends AbstractPresenterList<Usuario, UsuarioServicio> {
    @Inject
    public UsuarioListPresenter(UsuarioServicio servicio, FilterablePageableDataProvider<Usuario, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
