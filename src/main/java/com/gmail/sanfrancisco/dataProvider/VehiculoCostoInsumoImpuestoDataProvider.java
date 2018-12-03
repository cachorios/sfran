package com.gmail.sanfrancisco.dataProvider;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumoImpuesto;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Arrays;

@Dependent
public class VehiculoCostoInsumoImpuestoDataProvider extends FilterablePageableDataProvider<VehiculoCostoInsumoImpuesto, Long, String> {
    @Inject
    public VehiculoCostoInsumoImpuestoDataProvider(ServicioModelo<VehiculoCostoInsumoImpuesto> servicio) {
        super(servicio, Arrays.asList(
                new QuerySortOrder("id", SortDirection.ASCENDING))
        );
    }
}