package com.gmail.cacho.slapi.view.customs.params;


import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.service.ParametroServicio;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.views.parametro.ParamForm;
import com.gmail.cacho.backend.views.parametro.ParamFormPresenter;
import com.gmail.cacho.slapi.view.customs.commons.AbstractCustomSelect;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.enterprise.inject.spi.CDI;
import java.util.Arrays;
import java.util.List;

public  class ParamCSComponent extends AbstractCustomSelect<Parametro> {
    private ETipoParametro tipo;
    private  String titulo;
    public ParamCSComponent(String caption, IVisualizable padre, boolean conBuscar, boolean conVer) {
        super(caption, conBuscar, conVer, false, padre);
    }

    public ParamCSComponent(String caption, IVisualizable padre, boolean conBuscar, boolean conVer, String titulo, ETipoParametro tipo) {
        super(caption, conBuscar, conVer, false, padre);

        this.tipo = tipo;
        this.titulo = titulo;
    }

    protected  ETipoParametro getTipoParametro() {
        return tipo;
    };

    @Override
    protected FilterablePageableDataProvider<Parametro, Long, String> generarDataProvider() {
        ParamCSDataProvider pdp = CDI.current().select(ParamCSDataProvider.class).get();
        pdp.setTipo(getTipoParametro());
        pdp.setSortOrder(new QuerySortOrder("orden", SortDirection.ASCENDING));
        return pdp;
    }



    @Override
    protected Parametro getElemento(String codigo) {
        Parametro ret;
        Integer grupo = null;

        if(((ParamCSDataProvider) getDataProvider()).getGrupo() != null) {
            grupo = Math.toIntExact(((ParamCSDataProvider) getDataProvider()).getGrupo());
        }
        if( grupo == null)
            ret =  CDI.current().select(ParametroServicio.class).get().findByTipoAndOrden(getTipoParametro(), Integer.valueOf(codigo));
        else{
            ret =  CDI.current().select(ParametroServicio.class).get().findByTipoAndGrupoAndOrden(getTipoParametro(),grupo , Integer.valueOf(codigo));
        }

        return ret;
    }

    @Override
    protected void verElemento() {
        ParamForm pf = new ParamForm(new ParamFormPresenter(CDI.current().select(ParametroServicio.class).get()));
        pf.setPadre(this.getPadre());
        pf.iniciar(EModoVista.VER, getValue());
    }

    @Override
    protected String getCodigo() {
        try {
            return getValue().getOrden().toString();
        } catch (Exception ex) {
            return "";
        }
    }

    @Override
    protected List<ColumnList> getListaCols() {
        return Arrays.asList(
                new ColumnList<>(Parametro::getOrden, Parametro.F_PAR_ORDEN, "orden", true),
                new ColumnList<>(Parametro::getNombre, Parametro.F_PAR_NOMBRE, "nombre", true));
    }

    @Override
    protected String getListTitulo() {
        return "";
    }
}