package com.gmail.sanfrancisco.view.movil;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Movil;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class MovilForm extends AbstractForm<Movil> {
    @Inject
    public MovilForm(IPresenterForm<Movil> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<Movil> generarLayout(AbstractForm<Movil> padre, String titulo) {
        return new MovilInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_MOVIL"; }

    @Override
    public Class<Movil> getEntityType() { return Movil.class; }

    @Override
    public String getTitulo() {
        return "Movil";
    }
}
