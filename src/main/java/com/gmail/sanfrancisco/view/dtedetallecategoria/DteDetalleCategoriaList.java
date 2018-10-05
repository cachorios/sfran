package com.gmail.sanfrancisco.view.dtedetallecategoria;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;

import javax.inject.Inject;
import java.util.Arrays;

public class DteDetalleCategoriaList  extends AbstractList<DteDetalleCategoria> {
    @Inject
    public DteDetalleCategoriaList(IPresenterList<DteDetalleCategoria> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(DteDetalleCategoria::getCategoria,"Categoria","categoria", true),
                new ColumnList<>(DteDetalleCategoria::getCantidad,"Cantidad","cantidad", true),
                new ColumnList<>(DteDetalleCategoria::getKgVivo,"Kilogramos vivos","kilogramos vivos", true),
                new ColumnList<>(DteDetalleCategoria::getPrecioKgVivo,"Precio por kg vivos","precio por kg vivos", true),
                new ColumnList<>(DteDetalleCategoria::getKgCarne,"Kilogramos de carne","kilogramos de carne", true),
                new ColumnList<>(DteDetalleCategoria::getPorcentajeComision,"Porcentaje de comision","porcentaje de comision", true)
        ));
    }

    @Override
    public String getTagVista() {
        return "CATEGORIAS EN DTE";
    }

    @Override
    public Class<DteDetalleCategoria> getEntityType() {
        return DteDetalleCategoria.class;
    }

    @Override
    public String getTitulo() {
        return "Lista de categorias en DTE";
    }
}

