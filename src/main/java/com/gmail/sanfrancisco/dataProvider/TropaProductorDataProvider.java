package com.gmail.sanfrancisco.dataProvider;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.entidad.Productor;
import com.gmail.sanfrancisco.serviciosModelo.DteService;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.stream.Stream;

@Dependent
public class TropaProductorDataProvider  extends FilterablePageableDataProvider<Dte, Long, String> {
    private Productor productor;

    @Inject
    public TropaProductorDataProvider(ServicioModelo<Dte> servicio) {
        super(servicio, Arrays.asList(
                new QuerySortOrder("id", SortDirection.ASCENDING))
        );
    }

    @Override
    protected Stream<Dte> fetchFromBackEnd(Query<Dte, String> query) {
        return ((DteService)getServicio())
                .findAnyMatching(getPadre(), productor, query.getOffset(), query.getLimit(), getSortOrders(query));
    }

    @Override
    protected int sizeInBackEnd(Query<Dte, String> query) {
        return (int) ((DteService)getServicio()).countAnyMatching(getPadre(), productor);
    }

    public void setProductor(Productor p){
        productor = p;
    }
}
