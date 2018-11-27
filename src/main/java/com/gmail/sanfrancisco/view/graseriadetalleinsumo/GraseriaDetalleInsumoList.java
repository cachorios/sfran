package com.gmail.sanfrancisco.view.graseriadetalleinsumo;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleInsumo;

import javax.inject.Inject;
import java.util.Arrays;

public class GraseriaDetalleInsumoList extends AbstractList<GraseriaDetalleInsumo> {
    @Inject
    public GraseriaDetalleInsumoList(IPresenterList<GraseriaDetalleInsumo> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(GraseriaDetalleInsumo::getInsumo,"Insumo","insumo", true),
                new ColumnList<>(GraseriaDetalleInsumo::getCantidad,"Cantidad","cantidad", true),
                new ColumnList<>(GraseriaDetalleInsumo::getPrecio,"Precio","precio", true)
        ));
    }

    @Override
    public String getTagVista(){ return "GraseriaDetalleInsumo"; }

    @Override
    public Class<GraseriaDetalleInsumo> getEntityType() { return GraseriaDetalleInsumo.class; }

    @Override
    public String getTitulo() { return "Lista de Graserias"; }
}