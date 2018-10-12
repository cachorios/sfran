package com.gmail.sanfrancisco.view.insumocostovehiculo;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;

import javax.inject.Inject;
import java.util.Arrays;

public class InsumoCostoVehiculoList extends AbstractList<InsumoCostoVehiculo> {
    @Inject
    public InsumoCostoVehiculoList(IPresenterList<InsumoCostoVehiculo> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(InsumoCostoVehiculo::getCantidad,"Cantidad","cantidad", true),
                new ColumnList<>(InsumoCostoVehiculo::getPrecio,"Precio","precio", true)
        ));
    }

    @Override
    public String getTagVista(){ return "InsumoCostoVehiculo"; }

    @Override
    public Class<InsumoCostoVehiculo> getEntityType() { return InsumoCostoVehiculo.class; }

    @Override
    public String getTitulo() { return "Lista de Insumos en Costo de Vehiculo"; }
}