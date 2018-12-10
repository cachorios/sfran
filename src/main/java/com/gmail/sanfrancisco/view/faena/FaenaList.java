package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.renders.DateRenderer;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Faena;

import javax.inject.Inject;
import java.util.Arrays;

public class FaenaList extends AbstractList<Faena> {
    @Inject
    public FaenaList(IPresenterList<Faena> presenter) {
        super(presenter);

        setListaCols(Arrays.asList(
                new ColumnList<>(new DateRenderer<>(Faena::getFecha,"dd/MM/yyyy"),"Fecha","fecha", true,"45%"),
                new ColumnList<>(Faena::getNumero,"Numero","numero", true,"45%")
        ));
    }

    @Override
    public String getTagVista() {
        return "FAENA";
    }

    @Override
    public Class<Faena> getEntityType() { return Faena.class; }

    @Override
    public String getTitulo() {
        return "Lista de Faenas";
    }
}
