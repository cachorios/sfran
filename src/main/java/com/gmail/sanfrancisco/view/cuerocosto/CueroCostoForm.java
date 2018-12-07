package com.gmail.sanfrancisco.view.cuerocosto;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.CueroCosto;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class CueroCostoForm extends AbstractForm<CueroCosto> {

    @Inject
    public CueroCostoForm(IPresenterForm<CueroCosto> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<CueroCosto> generarLayout(AbstractForm<CueroCosto> padre, String titulo){
        return new CueroCostoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_CUERO"; }

    @Override
    public Class<CueroCosto> getEntityType() { return CueroCosto.class; }

    @Override
    public String getTitulo() {
        return "Costos de Cuero";
    }
}