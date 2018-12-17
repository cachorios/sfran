package com.gmail.cacho.backend.views.usuarios;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value = "usuarios", layout = MainView.class)
@PageTitle("Administracion de Usuarios")
@MenuIcon(VaadinIcon.USER)
public class UsuarioView extends AbstractDefaultView<Usuario> {

    @Inject
    protected UsuarioView(AbstractList<Usuario> list, AbstractPreview<Usuario> preview, AbstractForm<Usuario> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}

