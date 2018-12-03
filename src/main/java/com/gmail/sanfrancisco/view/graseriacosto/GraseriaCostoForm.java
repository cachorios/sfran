package com.gmail.sanfrancisco.view.graseriacosto;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.GraseriaCosto;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class GraseriaCostoForm extends AbstractForm<GraseriaCosto> {

    @Inject
    public GraseriaCostoForm(IPresenterForm<GraseriaCosto> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<GraseriaCosto> generarLayout(AbstractForm<GraseriaCosto> padre, String titulo){
        return new GraseriaCostoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_GRASERIA"; }

    @Override
    public Class<GraseriaCosto> getEntityType() { return GraseriaCosto.class; }

    @Override
    public String getTitulo() {
        return "Graserias";
    }
}
