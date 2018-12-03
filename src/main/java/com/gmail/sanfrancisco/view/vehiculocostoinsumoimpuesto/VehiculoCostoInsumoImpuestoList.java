package com.gmail.sanfrancisco.view.vehiculocostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumoImpuesto;

import javax.inject.Inject;
import java.util.Arrays;

public class VehiculoCostoInsumoImpuestoList extends AbstractList<VehiculoCostoInsumoImpuesto> {
    @Inject
    public VehiculoCostoInsumoImpuestoList(IPresenterList<VehiculoCostoInsumoImpuesto> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(VehiculoCostoInsumoImpuesto::getSaldo,"Saldo","saldo", true)
        ));
    }

    @Override
    public String getTagVista(){ return "VehiculoCostoInsumoImpuesto"; }

    @Override
    public Class<VehiculoCostoInsumoImpuesto> getEntityType() { return VehiculoCostoInsumoImpuesto.class; }

    @Override
    public String getTitulo() { return "Lista de Impuestos en Costo de Vehiculo"; }
}