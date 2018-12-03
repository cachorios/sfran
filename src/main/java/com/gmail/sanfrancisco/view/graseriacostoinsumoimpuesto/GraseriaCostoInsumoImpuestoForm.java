package com.gmail.sanfrancisco.view.graseriacostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumoImpuesto;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class GraseriaCostoInsumoImpuestoForm extends AbstractForm<GraseriaCostoInsumoImpuesto> {

    @Inject
    public GraseriaCostoInsumoImpuestoForm(IPresenterForm<GraseriaCostoInsumoImpuesto> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<GraseriaCostoInsumoImpuesto> generarLayout(AbstractForm<GraseriaCostoInsumoImpuesto> padre, String titulo){
        return new GraseriaCostoInsumoImpuestoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_GRASERIADETALLEIMPUESTO"; }

    @Override
    public Class<GraseriaCostoInsumoImpuesto> getEntityType() { return GraseriaCostoInsumoImpuesto.class; }

    @Override
    public String getTitulo() {
        return "Detalle de impuestos en graseria";
    }
}
