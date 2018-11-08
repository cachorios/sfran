package com.gmail.cacho.backend.jpa;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortOrder;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FilterablePageableDataProvider<U extends AbstractEntidad, TKI extends Serializable, F>   extends AbstractBackEndDataProvider<U, F> {
    private Object padre = null;
    private String filtro = "%";
    private ServicioModelo<U> servicio;
    private List<QuerySortOrder> defaultSortOrders;

    public FilterablePageableDataProvider(ServicioModelo<U> servicio, List<QuerySortOrder> defaultSortOrders) {
        super();
        this.servicio = servicio;
        this.defaultSortOrders = defaultSortOrders;
    }



    @Override
    protected Stream<U> fetchFromBackEnd(Query<U, F> query) {
        return getServicio()
                .findAnyMatching(getPadre(), getFiltro(), query.getOffset(), query.getLimit(), getSortOrders(query));
    }

    @Override
    protected int sizeInBackEnd(Query<U, F> query) {
        return (int) getServicio().countAnyMatching(getPadre(), getFiltro());
    }

    protected ServicioModelo<U> getServicio() { return servicio; }

    protected List<QuerySortOrder> getSortOrders(Query<U, F> q) {
        List<QuerySortOrder> sortOrders;
        if (q.getSortOrders().isEmpty()) {
            sortOrders = getDefaultSortOrders();
        } else {
            sortOrders = q.getSortOrders();
        }
        return sortOrders;

    }

    private List<QuerySortOrder> getDefaultSortOrders() {
        return defaultSortOrders;
    }

    public void setPadre(Object padre) {
        this.padre = padre;
        refreshAll();
    }

    public Object getPadre() { return padre; }

    public void setFiltro(String filtro) {
        this.filtro = filtro.toUpperCase();
        refreshAll();
    }

    public String getFiltro() { return filtro; }

    public Long getCantidadRegActual() {
        return getServicio().countAnyMatching(getPadre(), getFiltro());
    }

    public Long getCantidadRegTotal() {
        return getServicio().countAnyMatching(getPadre(), null);
    }
}