package com.gmail.sanfrancisco.view.vehiculocosto;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.renders.DateRenderer;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.VehiculoCosto;

import javax.inject.Inject;
import java.util.Arrays;

public class VehiculoCostoList extends AbstractList<VehiculoCosto> {
    @Inject
    public VehiculoCostoList(IPresenterList<VehiculoCosto> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(new DateRenderer<>(VehiculoCosto::getFecha, "dd/MM/yyyy"),"Fecha","fecha", true)
        ));
    }

    @Override
    public String getTagVista(){ return "VehiculoCosto"; }

    @Override
    public Class<VehiculoCosto> getEntityType() { return VehiculoCosto.class; }

    @Override
    public String getTitulo() { return "Costos de Vehiculos"; }
}