package com.gmail.sanfrancisco.view.graseria;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.renders.DateRenderer;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Graseria;
import com.vaadin.flow.data.renderer.LocalDateRenderer;

import javax.inject.Inject;
import java.util.Arrays;

public class GraseriaList extends AbstractList<Graseria> {
    @Inject
    public GraseriaList(IPresenterList<Graseria> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(new DateRenderer<>(Graseria::getFecha, "dd/MM/yyyy"),"Fecha","fecha", true)
        ));
    }

    @Override
    public String getTagVista(){ return "Graseria"; }

    @Override
    public Class<Graseria> getEntityType() { return Graseria.class; }

    @Override
    public String getTitulo() { return "Lista de Graserias"; }
}
