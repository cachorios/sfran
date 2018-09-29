package com.gmail.sanfrancisco.view.numerodte;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.NumeroDte;

import javax.inject.Inject;
import java.util.Arrays;

public class NumeroDteList extends AbstractList<NumeroDte> {
    @Inject
    public NumeroDteList(IPresenterList<NumeroDte> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(NumeroDte::getDescripcion, "Numero de DTE", "numero de dte", true)
        ));
    }

    @Override
    public String getTagVista() { return "NUMERO DE DTE"; }

    @Override
    public Class<NumeroDte> getEntityType() { return NumeroDte.class; }

    @Override
    public String getTitulo() { return "Lista de numeros de DTE"; }
}
