package com.gmail.cacho.backend.views.usuarios;


import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class UsuarioPreview extends AbstractPreview<Usuario> {
    @Override
    public void crearElementos() {
        addItem("username", new PreviewItem<>(textField("Usuario"), Usuario::getUsername));
        addItem("nombre", new PreviewItem<>(textField("Nombre usuario"), Usuario::getNombre));
        addItem("email", new PreviewItem<>(textField("Email"), Usuario::getEmail));
    }
}
