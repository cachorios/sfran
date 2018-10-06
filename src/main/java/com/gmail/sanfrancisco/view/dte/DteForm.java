package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Dte;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class DteForm extends AbstractForm<Dte> {

    @Inject
    public DteForm(IPresenterForm<Dte> presenter) {
        super(presenter);
    }

    @Override
    protected ILayoutInnerForm<Dte> generarLayout(AbstractForm<Dte> padre, String titulo) {
        return new DteInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return null;
    }

    @Override
    public String getTagVista() {
        return "RCV_TAG_DTE";
    }

    @Override
    public Class<Dte> getEntityType() {
        return Dte.class;
    }

    @Override
    public String getTitulo() {
        return "DTE";
    }
}
