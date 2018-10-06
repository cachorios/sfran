package com.gmail.sanfrancisco.dataProvider;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.service.ParamVariosServicio;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;

import java.util.List;
import java.util.stream.Stream;

public class OperadoraTelefonicaDataProvider extends FilterablePageableDataProvider<Parametro, Long, String> {
    private ParamVariosServicio servicio;
    private Long tipo;
    private String filtro;

    public OperadoraTelefonicaDataProvider(ParamVariosServicio servicio, List<QuerySortOrder> defaultSortOrders) {
        super(servicio, defaultSortOrders);
        this.servicio = servicio;
    }


    public void setTipo(Long tipo) {
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
        return servicio.findAnyMatching(tipo, filtro, query.getOffset(), query.getLimit(), getSortOrders(query));
    }

    @Override
    protected int sizeInBackEnd(Query<Parametro, String> query) {
        return (int) servicio.countAnyMatchingVarios(tipo, filtro);
    }
}
