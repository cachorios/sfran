package com.gmail.sanfrancisco.view.graseriacosto;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.renders.DateRenderer;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.GraseriaCosto;

import javax.inject.Inject;
import java.util.Arrays;

public class GraseriaCostoList extends AbstractList<GraseriaCosto> {
    @Inject
    public GraseriaCostoList(IPresenterList<GraseriaCosto> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(new DateRenderer<>(GraseriaCosto::getFecha, "dd/MM/yyyy"),"Fecha","fecha", true)
        ));
    }

    @Override
    public String getTagVista(){ return "GraseriaCosto"; }

    @Override
    public Class<GraseriaCosto> getEntityType() { return GraseriaCosto.class; }

    @Override
    public String getTitulo() { return "Lista Facturas  de costos de Graseria"; }
}
