package com.gmail.sanfrancisco.view.cuerocostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumoImpuesto;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class CueroCostoInsumoImpuestoForm extends AbstractForm<CueroCostoInsumoImpuesto> {

    @Inject
    public CueroCostoInsumoImpuestoForm(IPresenterForm<CueroCostoInsumoImpuesto> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<CueroCostoInsumoImpuesto> generarLayout(AbstractForm<CueroCostoInsumoImpuesto> padre, String titulo){
        return new CueroCostoInsumoImpuestoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_CUERODETALLEIMPUESTO"; }

    @Override
    public Class<CueroCostoInsumoImpuesto> getEntityType() { return CueroCostoInsumoImpuesto.class; }

    @Override
    public String getTitulo() {
        return "Impuestos de insumos en Cueros";
    }
}