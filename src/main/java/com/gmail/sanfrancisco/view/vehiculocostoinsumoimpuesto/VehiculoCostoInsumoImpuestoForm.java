package com.gmail.sanfrancisco.view.vehiculocostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumoImpuesto;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class VehiculoCostoInsumoImpuestoForm extends AbstractForm<VehiculoCostoInsumoImpuesto> {

    @Inject
    public VehiculoCostoInsumoImpuestoForm(IPresenterForm<VehiculoCostoInsumoImpuesto> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<VehiculoCostoInsumoImpuesto> generarLayout(AbstractForm<VehiculoCostoInsumoImpuesto> padre, String titulo){
        return new VehiculoCostoInsumoImpuestoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_IMPUESTOCOSTOVEHICULO"; }

    @Override
    public Class<VehiculoCostoInsumoImpuesto> getEntityType() { return VehiculoCostoInsumoImpuesto.class; }

    @Override
    public String getTitulo() {
        return "Impuestos de insumos en Vehiculos";
    }
}