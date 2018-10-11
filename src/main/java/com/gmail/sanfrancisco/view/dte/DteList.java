package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Dte;

import javax.inject.Inject;
import java.util.Arrays;

public class DteList  extends AbstractList<Dte> {
    @Inject
    public DteList(IPresenterList<Dte> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Dte::getFechaCarga,"Fecha Carga","fechaCarga", true),
                new ColumnList<>(Dte::getNumeroTropa,"Numero de tropa","numeroTropa", true),
                new ColumnList<>(Dte::getComisionista,"Comisionista","comisionista", true),
                new ColumnList<>(Dte::getProductor,"Productor","productor", true),
                new ColumnList<>(Dte::getCantidad,"Cantidad","cantidad", true),
                new ColumnList<>(Dte::getPeso,"Peso","peso", true),
                new ColumnList<>(Dte::getTotal,"Total de factura","total de factura", true)
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
}