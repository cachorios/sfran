package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Comisionista;

import javax.inject.Inject;
import java.util.Arrays;

public class ComisionistaList extends AbstractList<Comisionista> {
    @Inject
    public ComisionistaList(IPresenterList<Comisionista> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Comisionista::getNombre,"Nombre","nombre", true),
                new ColumnList<>(Comisionista::getApellido,"Apellido","apellido", true),
                new ColumnList<>(Comisionista::getCuil,"C.U.I.L.","cuil", true),
                new ColumnList<>(Comisionista::getEmail,"Correo electronico","correo electronico", true)
        ));
    }

    @Override
    public String getTagVista(){ return "COMISIONISTA"; }

    @Override
    public Class<Comisionista> getEntityType() { return Comisionista.class; }

    @Override
    public String getTitulo() { return "Lista de Comisionistas"; }
}

