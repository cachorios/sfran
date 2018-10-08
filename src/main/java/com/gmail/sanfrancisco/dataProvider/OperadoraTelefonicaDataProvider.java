package com.gmail.sanfrancisco.dataProvider;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.service.ParamVariosServicio;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.inject.Inject;
import java.util.Arrays;

import java.util.stream.Stream;

public class OperadoraTelefonicaDataProvider extends FilterablePageableDataProvider<Parametro, Long, String> {
    private ParamVariosServicio servicio;
    private ETipoParametro tipo;
    private String filtro;

    @Inject
    public OperadoraTelefonicaDataProvider(ParamVariosServicio servicio) {
        super(servicio, Arrays.asList(
                new QuerySortOrder("id", SortDirection.ASCENDING))
        );

        this.servicio = servicio;
    }


    public void setTipo(ETipoParametro tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getFiltro() {
        return filtro;
    }

    @Override
    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    @Override
    protected Stream<Parametro> fetchFromBackEnd(Query<Parametro, String> query) {
        filtro = filtro==null ? "%" :"%"+filtro;
        return servicio.findAnyMatching(tipo, filtro, query.getOffset(), query.getLimit(), getSortOrders(query));
    }

    @Override
    protected int sizeInBackEnd(Query<Parametro, String> query) {
        return (int) servicio.countAnyMatchingVarios(tipo, filtro);
    }
}
