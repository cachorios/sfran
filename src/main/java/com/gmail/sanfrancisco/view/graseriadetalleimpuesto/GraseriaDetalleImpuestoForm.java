package com.gmail.sanfrancisco.view.graseriadetalleimpuesto;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleImpuesto;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class GraseriaDetalleImpuestoForm extends AbstractForm<GraseriaDetalleImpuesto> {

    @Inject
    public GraseriaDetalleImpuestoForm(IPresenterForm<GraseriaDetalleImpuesto> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<GraseriaDetalleImpuesto> generarLayout(AbstractForm<GraseriaDetalleImpuesto> padre, String titulo){
        return new GraseriaDetalleImpuestoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_GRASERIADETALLEIMPUESTO"; }

    @Override
    public Class<GraseriaDetalleImpuesto> getEntityType() { return GraseriaDetalleImpuesto.class; }

    @Override
    public String getTitulo() {
        return "Detalle de impuestos en graseria";
    }
}
