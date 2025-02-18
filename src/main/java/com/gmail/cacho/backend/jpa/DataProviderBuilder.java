package com.gmail.cacho.backend.jpa;


import com.vaadin.flow.data.provider.CallbackDataProvider;
import com.vaadin.flow.data.provider.Query;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.vaadin.flow.data.provider.SortDirection.ASCENDING;

public class DataProviderBuilder<T, F> implements Serializable {

    private final DataProviderService<T, F> service;

    public DataProviderBuilder(DataProviderService<T, F> service) {
        this.service = service;
    }

    public CallbackDataProvider<T, F> newDataProvider() {
        return new CallbackDataProvider<>(this::fetch, this::count);
    }

    private int count(Query<T, F> query) {
        return service.count(query.getFilter().orElse(null));
    }

    private Stream<T> fetch(Query<T, F> query) {
        List<T> list = service.fetch(
                query.getOffset(),
                query.getLimit(),
                getSortOrderList(query),
                query.getFilter().orElse(null));
        return list.stream();
    }

    private List<SortOrder> getSortOrderList(Query<T, F> query) {
        return query.getSortOrders()
                .stream()
                .map(qso -> new SortOrder(qso.getSorted(),
                        qso.getDirection().equals(ASCENDING)))
                .collect(Collectors.toList());
    }

}
