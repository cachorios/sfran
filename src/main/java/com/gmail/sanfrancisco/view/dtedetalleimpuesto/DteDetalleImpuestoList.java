package com.gmail.sanfrancisco.view.dtedetalleimpuesto;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.DteDetalleImpuesto;

import javax.inject.Inject;
import java.util.Arrays;

public class DteDetalleImpuestoList  extends AbstractList<DteDetalleImpuesto> {
    @Inject
    public DteDetalleImpuestoList(IPresenterList<DteDetalleImpuesto> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(DteDetalleImpuesto::getSaldo,"Saldo","saldo", true)
        ));
    }

    @Override
    public String getTagVista() {
        return "IMPUESTOS EN DTE";
    }

    @Override
    public Class<DteDetalleImpuesto> getEntityType() {
        return DteDetalleImpuesto.class;
    }

    @Override
    public String getTitulo() {
        return "Lista de impuestos en DTE";
    }
}

