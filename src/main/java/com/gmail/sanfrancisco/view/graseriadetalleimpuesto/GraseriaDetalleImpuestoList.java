package com.gmail.sanfrancisco.view.graseriadetalleimpuesto;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleImpuesto;

import javax.inject.Inject;
import java.util.Arrays;

public class GraseriaDetalleImpuestoList extends AbstractList<GraseriaDetalleImpuesto> {
    @Inject
    public GraseriaDetalleImpuestoList(IPresenterList<GraseriaDetalleImpuesto> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(GraseriaDetalleImpuesto::getSaldo,"Saldo","saldo", true)
        ));
    }

    @Override
    public String getTagVista(){ return "GraseriaDetalleImpuesto"; }

    @Override
    public Class<GraseriaDetalleImpuesto> getEntityType() { return GraseriaDetalleImpuesto.class; }

    @Override
    public String getTitulo() { return "Detalle de impuestos en graseria"; }
}
