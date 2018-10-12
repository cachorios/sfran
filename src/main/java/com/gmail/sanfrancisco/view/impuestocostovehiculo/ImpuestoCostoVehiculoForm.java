package com.gmail.sanfrancisco.view.impuestocostovehiculo;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.ImpuestoCostoVehiculo;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class ImpuestoCostoVehiculoForm extends AbstractForm<ImpuestoCostoVehiculo> {

    @Inject
    public ImpuestoCostoVehiculoForm(IPresenterForm<ImpuestoCostoVehiculo> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<ImpuestoCostoVehiculo> generarLayout(AbstractForm<ImpuestoCostoVehiculo> padre, String titulo){
        return new ImpuestoCostoVehiculoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_IMPUESTOCOSTOVEHICULO"; }

    @Override
    public Class<ImpuestoCostoVehiculo> getEntityType() { return ImpuestoCostoVehiculo.class; }

    @Override
    public String getTitulo() {
        return "Impuestos de Costo de Vehiculo";
    }
}