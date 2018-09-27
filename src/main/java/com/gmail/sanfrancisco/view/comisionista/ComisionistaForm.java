package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class ComisionistaForm extends AbstractForm<Comisionista> {

    @Inject
    public ComisionistaForm(IPresenterForm<Comisionista> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<Comisionista> generarLayout(AbstractForm<Comisionista> padre, String titulo){
        return new ComisionistaInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_COMISIONISTA"; }

    @Override
    public Class<Comisionista> getEntityType() { return Comisionista.class; }
}