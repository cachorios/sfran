package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Faena;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class FaenaForm extends AbstractForm<Faena> {
    @Inject
    public FaenaForm(IPresenterForm<Faena> presenter) {
        super(presenter);
    }

    @Override
    protected ILayoutInnerForm<Faena> generarLayout(AbstractForm<Faena> padre, String titulo) {
        return new FaenaInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return null;
    }

    @Override
    public String getTagVista() {
        return "RCV_TAG_FAENA";
    }

    @Override
    public Class<Faena> getEntityType() {
        return Faena.class;
    }

    @Override
    public String getTitulo() {
        return "Faena";
    }
}
