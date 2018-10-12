package com.gmail.sanfrancisco.view.insumocostovehiculo;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class InsumoCostoVehiculoForm extends AbstractForm<InsumoCostoVehiculo> {

    @Inject
    public InsumoCostoVehiculoForm(IPresenterForm<InsumoCostoVehiculo> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<InsumoCostoVehiculo> generarLayout(AbstractForm<InsumoCostoVehiculo> padre, String titulo){
        return new InsumoCostoVehiculoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_INSUMOCOSTOVEHICULO"; }

    @Override
    public Class<InsumoCostoVehiculo> getEntityType() { return InsumoCostoVehiculo.class; }

    @Override
    public String getTitulo() {
        return "Insumos de Costo de Vehiculo";
    }
}