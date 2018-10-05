package com.gmail.sanfrancisco.view.dtedetalleinsumo;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class DteDetalleInsumoForm extends AbstractForm<DteDetalleInsumo> {

    @Inject
    public DteDetalleInsumoForm(IPresenterForm<DteDetalleInsumo> presenter) {
        super(presenter);
    }

    @Override
    protected ILayoutInnerForm<DteDetalleInsumo> generarLayout(AbstractForm<DteDetalleInsumo> padre, String titulo) {
        return new DteDetalleInsumoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return null;
    }

    @Override
    public String getTagVista() {
        return "RCV_TAG_DTEDETALLEINSUMO";
    }

    @Override
    public Class<DteDetalleInsumo> getEntityType() {
        return DteDetalleInsumo.class;
    }
}