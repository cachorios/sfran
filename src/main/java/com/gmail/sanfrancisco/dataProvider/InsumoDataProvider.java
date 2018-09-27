package com.gmail.sanfrancisco.dataProvider;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.inject.Inject;
import java.util.Arrays;

public class InsumoDataProvider extends FilterablePageableDataProvider<Insumo,Long,String> {
    @Inject
    public InsumoDataProvider(ServicioModelo<Insumo> servicio) {
        super(servicio, Arrays.asList(
                new QuerySortOrder("id", SortDirection.ASCENDING))
        );
    }
}
