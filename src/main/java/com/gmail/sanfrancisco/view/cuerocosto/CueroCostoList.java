package com.gmail.sanfrancisco.view.cuerocosto;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.renders.DateRenderer;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.CueroCosto;

import javax.inject.Inject;
import java.util.Arrays;

public class CueroCostoList extends AbstractList<CueroCosto> {
    @Inject
    public CueroCostoList(IPresenterList<CueroCosto> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(new DateRenderer<>(CueroCosto::getFecha, "dd/MM/yyyy"),"Fecha","fecha", true)
        ));
    }

    @Override
    public String getTagVista(){ return "CueroCosto"; }

    @Override
    public Class<CueroCosto> getEntityType() { return CueroCosto.class; }

    @Override
    public String getTitulo() { return "Costos de Cuero"; }

    @Override
    protected ILayoutInnerList<CueroCosto> generarLayout(AbstractList<CueroCosto> padre, String titulo) {
        return new CueroCostoInnerList(padre, getTitulo());
    }
}