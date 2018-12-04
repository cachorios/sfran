package com.gmail.sanfrancisco.view.vehiculocosto;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.VehiculoCosto;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class VehiculoCostoForm extends AbstractForm<VehiculoCosto> {

    @Inject
    public VehiculoCostoForm(IPresenterForm<VehiculoCosto> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<VehiculoCosto> generarLayout(AbstractForm<VehiculoCosto> padre, String titulo){
        return new VehiculoCostoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_FACTURACOSTOVEHICULO"; }

    @Override
    public Class<VehiculoCosto> getEntityType() { return VehiculoCosto.class; }

    @Override
    public String getTitulo() {
        return "Costos de Vehiculos";
    }
}