package com.gmail.sanfrancisco.view.graseriacostoinsumo;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumo;

import javax.inject.Inject;
import java.util.Arrays;

public class GraseriaCostoInsumoList extends AbstractList<GraseriaCostoInsumo> {
    @Inject
    public GraseriaCostoInsumoList(IPresenterList<GraseriaCostoInsumo> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(GraseriaCostoInsumo::getInsumo,"Insumo","insumo", true),
                new ColumnList<>(GraseriaCostoInsumo::getCantidad,"Cantidad","cantidad", true),
                new ColumnList<>(GraseriaCostoInsumo::getPrecio,"Precio","precio", true)
        ));
    }

    @Override
    public String getTagVista(){ return "GraseriaCostoInsumo"; }

    @Override
    public Class<GraseriaCostoInsumo> getEntityType() { return GraseriaCostoInsumo.class; }

    @Override
    public String getTitulo() { return "Insumos de Graserias"; }
}