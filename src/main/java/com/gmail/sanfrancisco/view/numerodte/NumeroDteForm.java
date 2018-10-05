package com.gmail.sanfrancisco.view.numerodte;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.NumeroDte;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class NumeroDteForm extends AbstractForm<NumeroDte> {

    @Inject
    public NumeroDteForm(IPresenterForm<NumeroDte> presenter) {
        super(presenter);
    }

    @Override
    protected ILayoutInnerForm<NumeroDte> generarLayout(AbstractForm<NumeroDte> padre, String titulo) {
        return new NumeroDteInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return null;
    }

    @Override
    public String getTagVista() {
        return "RCV_TAG_NUMERODTE";
    }

    @Override
    public Class<NumeroDte> getEntityType() {
        return NumeroDte.class;
    }
}
