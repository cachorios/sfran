package com.gmail.sanfrancisco.view.dtedetallecategoria;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.vaadin.flow.component.grid.Grid;

import javax.inject.Inject;
import java.util.Arrays;

public class DteDetalleCategoriaList  extends AbstractList<DteDetalleCategoria> {
    @Inject
    public DteDetalleCategoriaList(IPresenterList<DteDetalleCategoria> presenter) {
        super(presenter);
//        setListaCols(Arrays.asList(
//                new ColumnList<>(DteDetalleCategoria::getCategoria,"Categoria","categoria", true),
//                new ColumnList<>(DteDetalleCategoria::getCantidad,"Cantidad","cantidad", true),
//                new ColumnList<>(DteDetalleCategoria::getKgVivo,"Kilogramos vivos","kgvivos", true),
//                new ColumnList<>(DteDetalleCategoria::getPrecioKgVivo,"Precio por kg vivos","preciokgvivo", true),
//                new ColumnList<>(DteDetalleCategoria::getKgCarne,"Kilogramos de carne","kgcarne", true),
//                new ColumnList<>(DteDetalleCategoria::getPorcentajeComision,"Porcentaje de comision","porcentajecomision", true)
//        ));
    }

    @Override
    public void setCols(Grid<DteDetalleCategoria> grilla) {
        grilla.addColumn(DteDetalleCategoria::getProductor)
                .setHeader("Prodcutor")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("productor");

        grilla.addColumn(DteDetalleCategoria::getRenspa)
                .setHeader("RENSPA")
                .setWidth("8%")
                .setKey("renspa");
        grilla.addColumn(DteDetalleCategoria::getCategoria)
                .setHeader("Categoria")
                .setWidth("15%");

        grilla.addColumn(DteDetalleCategoria::getKgVivo)
                .setHeader("Kg. Vivo")
                .setWidth("10%");


        //        grilla.addColumn(Dte::getNumeroTropa)
//                .setHeader("Nro. Tropa")
//                .setWidth("200px")
//                .setSortable(true)
//                .setKey("numeroTropa")
//                .setFlexGrow(1);
//        grilla.addColumn(Dte::getFechaCarga)
//                .setHeader("Fecha Carga")
//                .setWidth("200px")
//                .setSortable(true)
//                .setKey("fechaCarga")
//                .setFlexGrow(1);
//    }
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

