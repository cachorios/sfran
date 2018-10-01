package com.gmail.sanfrancisco.view.renspa;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class RenspaForm extends AbstractForm<Renspa> {

    @Inject
    public RenspaForm(IPresenterForm<Renspa> presenter) {
        super(presenter);
    }

    @Override
    protected ILayoutInnerForm<Renspa> generarLayout(AbstractForm<Renspa> padre, String titulo) {
        return new RenspaInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return null;
    }

    @Override
    public String getTagVista() {
        return "RCV_TAG_RENSPA";
    }

    @Override
    public Class<Renspa> getEntityType() {
        return Renspa.class;
    }
}
