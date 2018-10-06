package com.gmail.sanfrancisco.view.productor;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Productor;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class ProductorForm extends AbstractForm<Productor> {

    @Inject
    public ProductorForm(IPresenterForm<Productor> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<Productor> generarLayout(AbstractForm<Productor> padre, String titulo){
        return new ProductorInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_PRODUCTOR"; }

    @Override
    public Class<Productor> getEntityType() { return Productor.class; }

    @Override
    public String getTitulo() {
        return "Productor";
    }
}