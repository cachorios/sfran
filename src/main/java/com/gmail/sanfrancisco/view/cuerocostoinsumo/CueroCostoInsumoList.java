package com.gmail.sanfrancisco.view.cuerocostoinsumo;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumo;

import javax.inject.Inject;
import java.util.Arrays;

public class CueroCostoInsumoList extends AbstractList<CueroCostoInsumo> {
    @Inject
    public CueroCostoInsumoList(IPresenterList<CueroCostoInsumo> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(CueroCostoInsumo::getInsumo,"Insumo","insumo", true),
                new ColumnList<>(CueroCostoInsumo::getCantidad,"Cantidad","cantidad", true),
                new ColumnList<>(CueroCostoInsumo::getPrecio,"Precio","precio", true)
        ));
    }

    @Override
    public String getTagVista(){ return "CueroCostoInsumo"; }

    @Override
    public Class<CueroCostoInsumo> getEntityType() { return CueroCostoInsumo.class; }

    @Override
    public String getTitulo() { return "Insumos de Cueros"; }
}