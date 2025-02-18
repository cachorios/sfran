package com.gmail.sanfrancisco.view.vehiculo;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;


public class VehiculoForm extends AbstractForm<Vehiculo> {
    @Inject
    public VehiculoForm(IPresenterForm<Vehiculo> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<Vehiculo> generarLayout(AbstractForm<Vehiculo> padre, String titulo) {
        return new VehiculoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_VEHICULO"; }

    @Override
    public Class<Vehiculo> getEntityType() { return Vehiculo.class; }

    @Override
    public String getTitulo() {
        return "Vehiculo";
    }
}
