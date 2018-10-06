package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class ConductorForm extends AbstractForm<Conductor> {

    @Inject
    public ConductorForm(IPresenterForm<Conductor> presenter) {
        super(presenter);
    }

    @Override
    protected ILayoutInnerForm<Conductor> generarLayout(AbstractForm<Conductor> padre, String titulo) {
        return new ConductorInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return null;
    }

    @Override
    public String getTagVista() {
        return "RCV_TAG_CONDUCTOR";
    }

    @Override
    public Class<Conductor> getEntityType() {
        return Conductor.class;
    }

    @Override
    public String getTitulo() {
        return "Conductor";
    }
}
