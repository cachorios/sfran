package com.gmail.sanfrancisco.dataProvider;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Dte;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Arrays;

@Dependent
public class DteDataProvider extends FilterablePageableDataProvider<Dte, Long, String> {
    @Inject
    public DteDataProvider(ServicioModelo<Dte> servicio) {
        super(servicio, Arrays.asList(
                new QuerySortOrder("fechaCarga", SortDirection.DESCENDING))
        );
    }


}

