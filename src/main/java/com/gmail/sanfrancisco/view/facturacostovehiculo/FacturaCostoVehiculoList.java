package com.gmail.sanfrancisco.view.facturacostovehiculo;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.FacturaCostoVehiculo;

import javax.inject.Inject;
import java.util.Arrays;

public class FacturaCostoVehiculoList extends AbstractList<FacturaCostoVehiculo> {
    @Inject
    public FacturaCostoVehiculoList(IPresenterList<FacturaCostoVehiculo> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(FacturaCostoVehiculo::getFecha,"Fecha","fecha", true)
        ));
    }

    @Override
    public String getTagVista(){ return "FacturaCostoVehiculo"; }

    @Override
    public Class<FacturaCostoVehiculo> getEntityType() { return FacturaCostoVehiculo.class; }

    @Override
    public String getTitulo() { return "Lista de Facturas Vehiculos"; }
}