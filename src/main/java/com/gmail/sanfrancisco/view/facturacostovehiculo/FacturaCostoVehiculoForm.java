package com.gmail.sanfrancisco.view.facturacostovehiculo;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.FacturaCostoVehiculo;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class FacturaCostoVehiculoForm extends AbstractForm<FacturaCostoVehiculo> {

    @Inject
    public FacturaCostoVehiculoForm(IPresenterForm<FacturaCostoVehiculo> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<FacturaCostoVehiculo> generarLayout(AbstractForm<FacturaCostoVehiculo> padre, String titulo){
        return new FacturaCostoVehiculoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_FACTURACOSTOVEHICULO"; }

    @Override
    public Class<FacturaCostoVehiculo> getEntityType() { return FacturaCostoVehiculo.class; }

    @Override
    public String getTitulo() {
        return "Factura costos de vehiculo";
    }
}