package com.gmail.cacho.backend.views.Parametro;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.slapi.comunes.Recursos;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.vaadin.flow.router.Route;
import org.apache.openjpa.lib.meta.MetaDataFilter;

import javax.inject.Inject;
import java.util.Arrays;



@Route
public class ParamList extends AbstractList<Parametro> {
    @Inject
    public ParamList(ParamListPresenter presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Parametro::getId, "ID", "id", true),
                new ColumnList<>(Parametro::getTipo, Parametro.F_PAR_TIPO, "tipo", true),
                new ColumnList<>(Parametro::getClase, Parametro.F_PAR_CLASE, "clase", true),
                new ColumnList<>(Parametro::getOrden, Parametro.F_PAR_ORDEN, "orden", true),
                new ColumnList<>(Parametro::getNombre, Parametro.F_PAR_NOMBRE, "nombre", true)));
    }

    public ParamList(ParamListPresenter presenter, IVisualizable padre) {
        this(presenter);
        this.setPadre(padre);
    }

    @Override
    public String getTagVista() {
        return    Recursos.RCV_TAG_PARAM;
    }

    @Override
    public Class<Parametro> getEntityType() {
        return Parametro.class;
    }

    @Override
    public String getTitulo() {
        return Recursos.RCV_TITULO_LIST_PARAM;
    }
}