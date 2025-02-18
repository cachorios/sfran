package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.renders.DateRenderer;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Dte;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.data.renderer.LocalDateTimeRenderer;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class DteList  extends AbstractList<Dte> {
    @Inject
    public DteList(IPresenterList<Dte> presenter) {
        super(presenter);

        setListaCols(Arrays.asList(
            new ColumnList<>(new DateRenderer<>(Dte::getFechaCarga,"dd/MM/yyyy"),"Fecha Carga","fechaCarga", true,"8%"),
            new ColumnList<>(Dte::getNumeroTropa,"Numero tropa","numeroTropa", true,"5%"),
            new ColumnList<>(Dte::getComisionista,"Comisionista","comisionista", true,"25%"),
            new ColumnList<>(Dte::getCantidad,"Cantidad","cantidad", true,"5%"),
            new ColumnList<>(Dte::getPesoTotal,"Peso total","peso", true,"10%"),
            new ColumnList<>(Dte::getTotalComisionista,"Total factura","totalcomisionista", true,"10%")
        ));
    }

    @Override
    public String getTagVista() {
        return "DTE";
    }

    @Override
    public Class<Dte> getEntityType() { return Dte.class; }

    @Override
    public String getTitulo() {
        return "Lista de DTE's";
    }

    @Override
    protected ILayoutInnerList<Dte> generarLayout(AbstractList<Dte> padre, String titulo) {
        return new DteInnerList(padre, getTitulo());
    }


//    public void setCols(Grid<Dte> grilla) {
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