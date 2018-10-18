package com.gmail.cacho.slapi.view.customs.params;


import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.service.ParametroServicio;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.stream.Stream;

@Dependent
public class ParamCSDataProvider extends FilterablePageableDataProvider<Parametro, Long, String> {
    private ETipoParametro tipo;
    private Long grupo;

    @Inject
    public ParamCSDataProvider(ParametroServicio servicio) {
        super(servicio, Arrays.asList(new QuerySortOrder("orden", SortDirection.ASCENDING)));
    }

    public void setTipo(ETipoParametro tipo){
        this.tipo = tipo;
    }

    @Override
    public Object getPadre() {
        return tipo;
    }

    public void setGrupo(Long grupo){
        this.grupo = grupo;
    }

    public Long getGrupo() {
        return grupo;
    }

    @Override
    protected Stream<Parametro> fetchFromBackEnd(Query<Parametro, String> query) {
        Stream str;
        if(grupo == null)
            str = ((ParametroServicio)getServicio())
                    .findAnyMatching(getPadre(),getFiltro(), query.getOffset(), query.getLimit(), getSortOrders(query));
        else
            str = ((ParametroServicio)getServicio())
                .findAnyMatching(getPadre(),grupo , getFiltro(), query.getOffset(), query.getLimit(), getSortOrders(query));
        return str;
    }

    @Override
    protected int sizeInBackEnd(Query<Parametro, String> query) {
        int reg = 0;

        if(grupo == null)
            reg = Math.toIntExact(((ParametroServicio) getServicio())
                    .countAnyMatching(getPadre(), getFiltro()));
        else
            reg = Math.toIntExact(((ParametroServicio) getServicio())
                    .countAnyMatching(getPadre(), grupo, getFiltro(), query.getOffset(), query.getLimit(), getSortOrders(query)));

        return reg;

    }
}

