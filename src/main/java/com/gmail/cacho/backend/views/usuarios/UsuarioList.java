package com.gmail.cacho.backend.views.usuarios;

import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;

import javax.inject.Inject;
import java.util.Arrays;

public class UsuarioList extends AbstractList<Usuario> {
    @Inject
    public UsuarioList(IPresenterList<Usuario> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Usuario::getUsername, "Usuario", "usuario", true),
                new ColumnList<>(Usuario::getNombre, "Nombre", "nombre", true),
                new ColumnList<>(Usuario::getEmail, "Email", "email", true)
//                new ColumnList<>(Usuario::getActivo, "Activo", "Activo", true)
        ));
    }

    @Override
    public String getTagVista() {
        return "USUARIO";
    }

    @Override
    public Class<Usuario> getEntityType() {
        return Usuario.class;
    }

    @Override
    public String getTitulo() {
        return "Lista de Usuarios";
    }

}

