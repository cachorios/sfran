package com.gmail.sanfrancisco.view.vehiculocostoinsumo;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumo;

import javax.inject.Inject;
import java.util.Arrays;

public class VehiculoCostoInsumoList extends AbstractList<VehiculoCostoInsumo> {
    @Inject
    public VehiculoCostoInsumoList(IPresenterList<VehiculoCostoInsumo> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(VehiculoCostoInsumo::getCantidad,"Cantidad","cantidad", true),
                new ColumnList<>(VehiculoCostoInsumo::getPrecio,"Precio","precio", true)
        ));
    }

    @Override
    public String getTagVista(){ return "VehiculoCostoInsumo"; }

    @Override
    public Class<VehiculoCostoInsumo> getEntityType() { return VehiculoCostoInsumo.class; }

    @Override
    public String getTitulo() { return "Insumos de Vehiculos"; }
}