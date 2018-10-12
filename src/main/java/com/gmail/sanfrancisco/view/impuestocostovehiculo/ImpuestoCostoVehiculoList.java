package com.gmail.sanfrancisco.view.impuestocostovehiculo;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.ImpuestoCostoVehiculo;

import javax.inject.Inject;
import java.util.Arrays;

public class ImpuestoCostoVehiculoList extends AbstractList<ImpuestoCostoVehiculo> {
    @Inject
    public ImpuestoCostoVehiculoList(IPresenterList<ImpuestoCostoVehiculo> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(ImpuestoCostoVehiculo::getSaldo,"Saldo","saldo", true)
        ));
    }

    @Override
    public String getTagVista(){ return "ImpuestoCostoVehiculo"; }

    @Override
    public Class<ImpuestoCostoVehiculo> getEntityType() { return ImpuestoCostoVehiculo.class; }

    @Override
    public String getTitulo() { return "Lista de Impuestos en Costo de Vehiculo"; }
}