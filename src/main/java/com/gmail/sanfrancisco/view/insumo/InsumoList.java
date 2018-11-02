package com.gmail.sanfrancisco.view.insumo;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Insumo;

import javax.inject.Inject;
import java.util.Arrays;

public class InsumoList extends AbstractList<Insumo> {
    @Inject
    public InsumoList(IPresenterList<Insumo> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Insumo::getDescripcion, "Descripción", "descripcion", true),
                new ColumnList<>(Insumo::getTipoInsumo, "Tipo insumo", "tipoinsumo", true),
                new ColumnList<>(Insumo::getUnidadMedida, "Unidad", "unidad", true)
        ));
    }

    @Override
    public String getTagVista() { return "INSUMO"; }

    @Override
    public Class<Insumo> getEntityType() { return Insumo.class; }

    @Override
    public String getTitulo() { return "Lista de Insumos"; }
}
