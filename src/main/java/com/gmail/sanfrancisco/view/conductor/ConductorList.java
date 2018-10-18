package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Conductor;

import javax.inject.Inject;
import java.util.Arrays;

public class ConductorList extends AbstractList<Conductor> {
    @Inject
    public ConductorList(IPresenterList<Conductor> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Conductor::getApellido, "Apellido", "apellido", true),
                new ColumnList<>(Conductor::getNombre, "Nombre", "nombre", true),
                new ColumnList<>(Conductor::getCuil, "C.U.I.L.", "cuil", true)
        ));

    }

    @Override
    public String getTagVista() {
        return "CONDUCTOR";
    }

    @Override
    public Class<Conductor> getEntityType() {
        return Conductor.class;
    }

    @Override
    public String getTitulo() {
        return "Lista de Conductores";
    }

    @Override
    protected ILayoutInnerList<Conductor> generarLayout(AbstractList<Conductor> padre, String titulo) {
        return new ConductorInnerList(padre, getTitulo());
    }

}

