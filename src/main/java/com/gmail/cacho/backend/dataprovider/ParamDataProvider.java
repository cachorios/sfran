package com.gmail.cacho.backend.dataprovider;


import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.service.ParametroServicio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Arrays;

@Dependent
public class ParamDataProvider extends FilterablePageableDataProvider<Parametro, Long, String> {
    @Inject
    public ParamDataProvider(ParametroServicio servicio) {
        super(servicio, Arrays.asList(new QuerySortOrder("id", SortDirection.ASCENDING)));
    }
}
