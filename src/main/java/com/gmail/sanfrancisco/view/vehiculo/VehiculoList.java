package com.gmail.sanfrancisco.view.vehiculo;

import com.gmail.cacho.slapi.view.AbstractList;
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
                new ColumnList<>(Vehiculo::getEstadoMovil, "Estado del vehiculo", "estadomovil", true),
                new ColumnList<>(Vehiculo::getMaxCabezas, "Maximo de cabezas", "maxcabezas", true)
        ));
    }

    @Override
    public String getTagVista() { return  "MOVIL"; }

    @Override
    public Class<Vehiculo> getEntityType() { return Vehiculo.class; }

    @Override
    public String getTitulo() { return "Lista de moviles"; }
}
