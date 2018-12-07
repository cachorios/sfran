package com.gmail.sanfrancisco.view.cuerocostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumoImpuesto;

import javax.inject.Inject;
import java.util.Arrays;

public class CueroCostoInsumoImpuestoList extends AbstractList<CueroCostoInsumoImpuesto> {
    @Inject
    public CueroCostoInsumoImpuestoList(IPresenterList<CueroCostoInsumoImpuesto> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(CueroCostoInsumoImpuesto::getSaldo,"Saldo","saldo", true)
        ));
    }

    @Override
    public String getTagVista(){ return "CueroCostoInsumoImpuesto"; }

    @Override
    public Class<CueroCostoInsumoImpuesto> getEntityType() { return CueroCostoInsumoImpuesto.class; }

    @Override
    public String getTitulo() { return "Impuestos de insumos en Cueros"; }
}