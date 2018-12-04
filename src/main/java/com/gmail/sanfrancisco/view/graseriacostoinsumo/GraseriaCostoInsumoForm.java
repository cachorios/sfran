package com.gmail.sanfrancisco.view.graseriacostoinsumo;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumo;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class GraseriaCostoInsumoForm extends AbstractForm<GraseriaCostoInsumo> {

    @Inject
    public GraseriaCostoInsumoForm(IPresenterForm<GraseriaCostoInsumo> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<GraseriaCostoInsumo> generarLayout(AbstractForm<GraseriaCostoInsumo> padre, String titulo){
        return new GraseriaCostoInsumoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_GRASERIADETALLEINSUMO"; }

    @Override
    public Class<GraseriaCostoInsumo> getEntityType() { return GraseriaCostoInsumo.class; }

    @Override
    public String getTitulo() {
        return "Insumos de Graserias";
    }
}
