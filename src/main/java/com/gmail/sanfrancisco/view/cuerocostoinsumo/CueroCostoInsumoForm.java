package com.gmail.sanfrancisco.view.cuerocostoinsumo;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumo;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class CueroCostoInsumoForm extends AbstractForm<CueroCostoInsumo> {

    @Inject
    public CueroCostoInsumoForm(IPresenterForm<CueroCostoInsumo> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<CueroCostoInsumo> generarLayout(AbstractForm<CueroCostoInsumo> padre, String titulo){
        return new CueroCostoInsumoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_CUERODETALLEINSUMO"; }

    @Override
    public Class<CueroCostoInsumo> getEntityType() { return CueroCostoInsumo.class; }

    @Override
    public String getTitulo() {
        return "Insumos de Cueros";
    }
}