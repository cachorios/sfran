package com.gmail.sanfrancisco.view.vehiculo;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Vehiculo;

import javax.inject.Inject;
import java.util.Arrays;

public class VehiculoList extends AbstractList<Vehiculo> {
    @Inject
    public VehiculoList(IPresenterList<Vehiculo> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Vehiculo::getDominio, "Dominio","dominio",true),
                new ColumnList<>(Vehiculo::getTipoVehiculo, "Tipo vehiculo", "tipoVehiculo", true),
                new ColumnList<>(Vehiculo::getTipoCombustible, "Tipo combustible", "tipoCombustible", true),
                new ColumnList<>(Vehiculo::getMaxCabezas, "Maximo de cabezas", "maxcabezas", true),
                new ColumnList<>(Vehiculo::getCargaMax, "Carga maxima", "cargaMax", true)
        ));
    }

    @Override
    public String getTagVista() { return  "VEHICULO"; }

    @Override
    public Class<Vehiculo> getEntityType() { return Vehiculo.class; }

    @Override
    public String getTitulo() { return "Lista de Vehiculos"; }

    @Override
    protected ILayoutInnerList<Vehiculo> generarLayout(AbstractList<Vehiculo> padre, String titulo) {
        return new VehiculoInnerList(padre, getTitulo());
    }
}
