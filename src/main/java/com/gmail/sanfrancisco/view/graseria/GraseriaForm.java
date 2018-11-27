package com.gmail.sanfrancisco.view.graseria;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Graseria;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class GraseriaForm extends AbstractForm<Graseria> {

    @Inject
    public GraseriaForm(IPresenterForm<Graseria> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<Graseria> generarLayout(AbstractForm<Graseria> padre, String titulo){
        return new GraseriaInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_GRASERIA"; }

    @Override
    public Class<Graseria> getEntityType() { return Graseria.class; }

    @Override
    public String getTitulo() {
        return "Graserias";
    }
}
