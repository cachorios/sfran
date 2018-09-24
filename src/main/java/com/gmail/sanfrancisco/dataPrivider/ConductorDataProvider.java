package com.gmail.sanfrancisco.dataPrivider;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Arrays;


@Dependent
public class ConductorDataProvider extends FilterablePageableDataProvider<Conductor,Long, String> {
    @Inject
    public ConductorDataProvider(ServicioModelo<Conductor> servicio) {
        super(servicio, Arrays.asList(
                        new QuerySortOrder("id", SortDirection.ASCENDING))
            );
    }
}
