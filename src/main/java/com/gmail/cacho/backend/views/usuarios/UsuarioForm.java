package com.gmail.cacho.backend.views.usuarios;

import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.slapi.comunes.Recursos;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class UsuarioForm extends AbstractForm<Usuario> {
    @Inject
    public UsuarioForm(IPresenterForm<Usuario> presenter) {
        super(presenter);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return ((UsuarioInnerForm)getViewComponent()).getPrimerElementoForm();
    }

    @Override
    public String getTagVista() {
        return Recursos.RCV_TAG_USUARIO;
    }

    @Override
    public Class<Usuario> getEntityType() {
        return Usuario.class;
    }

    @Override
    public String getTitulo() {
        return Recursos.RCV_TITULO_FORM_USUARIO;
    }

    @Override
    protected ILayoutInnerForm<Usuario> generarLayout(AbstractForm<Usuario> padre, String titulo) {
        return new UsuarioInnerForm(padre, titulo);
    }

}