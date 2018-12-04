package com.gmail.sanfrancisco.view.vehiculocostoinsumo;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumo;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class VehiculoCostoInsumoForm extends AbstractForm<VehiculoCostoInsumo> {

    @Inject
    public VehiculoCostoInsumoForm(IPresenterForm<VehiculoCostoInsumo> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<VehiculoCostoInsumo> generarLayout(AbstractForm<VehiculoCostoInsumo> padre, String titulo){
        return new VehiculoCostoInsumoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_INSUMOCOSTOVEHICULO"; }

    @Override
    public Class<VehiculoCostoInsumo> getEntityType() { return VehiculoCostoInsumo.class; }

    @Override
    public String getTitulo() {
        return "Insumos de Vehiculos";
    }
}