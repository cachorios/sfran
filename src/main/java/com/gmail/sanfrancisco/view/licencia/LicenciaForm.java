package com.gmail.sanfrancisco.view.licencia;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class LicenciaForm extends AbstractForm<Licencia> {

    @Inject
    public LicenciaForm(IPresenterForm<Licencia> presenter) {
        super(presenter);
    }

    @Override
    protected ILayoutInnerForm<Licencia> generarLayout(AbstractForm<Licencia> padre, String titulo) {
        return new LicenciaInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return null;
    }

    @Override
    public String getTagVista() {
        return "RCV_TAG_LICENCIA";
    }

    @Override
    public Class<Licencia> getEntityType() {
        return Licencia.class;
    }
}
