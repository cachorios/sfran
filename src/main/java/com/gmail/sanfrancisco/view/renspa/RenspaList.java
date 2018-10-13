package com.gmail.sanfrancisco.view.renspa;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Renspa;

import javax.inject.Inject;
import java.util.Arrays;

public class RenspaList extends AbstractList<Renspa> {
    @Inject
    public RenspaList(IPresenterList<Renspa> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Renspa::getDescripcion, "Numero de Renspa", "descripcion", true)
        ));
    }

    @Override
    public String getTagVista() { return "NUMERO DE RENSPA"; }

    @Override
    public Class<Renspa> getEntityType() { return Renspa.class; }

    @Override
    public String getTitulo() { return "Lista de numeros de Renspa"; }
}
