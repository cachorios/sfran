package com.gmail.sanfrancisco.dataProvider;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Arrays;

@Dependent
public class RenspaDataProvider extends FilterablePageableDataProvider<Renspa, Long, String> {
    @Inject
    public RenspaDataProvider(ServicioModelo<Renspa> servicio) {
        super(servicio, Arrays.asList(
                new QuerySortOrder("id",SortDirection.ASCENDING))
        );
    }
}
