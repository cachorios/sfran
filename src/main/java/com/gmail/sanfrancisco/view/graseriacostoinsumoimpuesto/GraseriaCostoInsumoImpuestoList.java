package com.gmail.sanfrancisco.view.graseriacostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumoImpuesto;

import javax.inject.Inject;
import java.util.Arrays;

public class GraseriaCostoInsumoImpuestoList extends AbstractList<GraseriaCostoInsumoImpuesto> {
    @Inject
    public GraseriaCostoInsumoImpuestoList(IPresenterList<GraseriaCostoInsumoImpuesto> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(GraseriaCostoInsumoImpuesto::getSaldo,"Saldo","saldo", true)
        ));
    }

    @Override
    public String getTagVista(){ return "GraseriaCostoInsumoImpuesto"; }

    @Override
    public Class<GraseriaCostoInsumoImpuesto> getEntityType() { return GraseriaCostoInsumoImpuesto.class; }

    @Override
    public String getTitulo() { return "Detalle de impuestos en graseria"; }
}
