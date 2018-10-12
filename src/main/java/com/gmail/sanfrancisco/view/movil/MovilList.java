package com.gmail.sanfrancisco.view.movil;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Movil;

import javax.inject.Inject;
import java.util.Arrays;

public class MovilList extends AbstractList<Movil> {
    @Inject
    public MovilList(IPresenterList<Movil> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Movil::getDominio, "Dominio","dominio",true),
                new ColumnList<>(Movil::getEstadoMovil, "Estado del movil", "estadomovil", true),
                new ColumnList<>(Movil::getMaxCabezas, "Maximo de cabezas", "maxcabezas", true)
        ));
    }

    @Override
    public String getTagVista() { return  "MOVIL"; }

    @Override
    public Class<Movil> getEntityType() { return Movil.class; }

    @Override
    public String getTitulo() { return "Lista de moviles"; }
}
