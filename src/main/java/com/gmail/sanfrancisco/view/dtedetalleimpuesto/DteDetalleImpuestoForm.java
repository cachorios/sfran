package com.gmail.sanfrancisco.view.dtedetalleimpuesto;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.DteDetalleImpuesto;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class DteDetalleImpuestoForm extends AbstractForm<DteDetalleImpuesto> {

    @Inject
    public DteDetalleImpuestoForm(IPresenterForm<DteDetalleImpuesto> presenter) {
        super(presenter);
    }

    @Override
    protected ILayoutInnerForm<DteDetalleImpuesto> generarLayout(AbstractForm<DteDetalleImpuesto> padre, String titulo) {
        return new DteDetalleImpuestoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return null;
    }

    @Override
    public String getTagVista() {
        return "RCV_TAG_DTEDETALLEIMPUESTO";
    }

    @Override
    public Class<DteDetalleImpuesto> getEntityType() {
        return DteDetalleImpuesto.class;
    }

    @Override
    public String getTitulo() {
        return "Impuestos de un DTE";
    }
}