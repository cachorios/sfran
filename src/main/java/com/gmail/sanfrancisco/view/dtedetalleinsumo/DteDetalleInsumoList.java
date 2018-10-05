package com.gmail.sanfrancisco.view.dtedetalleinsumo;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;

import javax.inject.Inject;
import java.util.Arrays;

public class DteDetalleInsumoList  extends AbstractList<DteDetalleInsumo> {
    @Inject
    public DteDetalleInsumoList(IPresenterList<DteDetalleInsumo> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(DteDetalleInsumo::getInsumo,"Insumo","insumo", true),
                new ColumnList<>(DteDetalleInsumo::getCantidad,"Cantidad","cantidad", true),
                new ColumnList<>(DteDetalleInsumo::getPrecio,"Precio","precio", true)

        ));
    }

    @Override
    public String getTagVista() {
        return "INSUMOS EN DTE";
    }

    @Override
    public Class<DteDetalleInsumo> getEntityType() {
        return DteDetalleInsumo.class;
    }

    @Override
    public String getTitulo() {
        return "Lista de insumos en DTE";
    }
}

