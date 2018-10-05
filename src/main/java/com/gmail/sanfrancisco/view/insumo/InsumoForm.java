package com.gmail.sanfrancisco.view.insumo;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class InsumoForm extends AbstractForm<Insumo> {

    @Inject
    public InsumoForm(IPresenterForm<Insumo> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<Insumo> generarLayout(AbstractForm<Insumo> padre, String titulo) {
        return new InsumoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista(){ return "RCV_TAG_INSUMO"; }

    @Override
    public Class<Insumo> getEntityType() { return Insumo.class; }
}
