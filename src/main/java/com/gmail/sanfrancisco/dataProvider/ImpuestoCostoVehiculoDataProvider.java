package com.gmail.sanfrancisco.dataProvider;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.ImpuestoCostoVehiculo;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Arrays;

@Dependent
public class ImpuestoCostoVehiculoDataProvider extends FilterablePageableDataProvider<ImpuestoCostoVehiculo, Long, String> {
    @Inject
    public ImpuestoCostoVehiculoDataProvider(ServicioModelo<ImpuestoCostoVehiculo> servicio) {
        super(servicio, Arrays.asList(
                new QuerySortOrder("id", SortDirection.ASCENDING))
        );
    }
}