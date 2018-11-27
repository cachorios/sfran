package com.gmail.sanfrancisco.view.graseriadetalleinsumo;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleInsumo;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class GraseriaDetalleInsumoForm extends AbstractForm<GraseriaDetalleInsumo> {

    @Inject
    public GraseriaDetalleInsumoForm(IPresenterForm<GraseriaDetalleInsumo> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<GraseriaDetalleInsumo> generarLayout(AbstractForm<GraseriaDetalleInsumo> padre, String titulo){
        return new GraseriaDetalleInsumoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_GRASERIADETALLEINSUMO"; }

    @Override
    public Class<GraseriaDetalleInsumo> getEntityType() { return GraseriaDetalleInsumo.class; }

    @Override
    public String getTitulo() {
        return "Detalle de insumos en graseria";
    }
}
