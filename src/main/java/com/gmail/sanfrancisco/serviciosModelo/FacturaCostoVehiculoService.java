package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.FacturaCostoVehiculo;
import com.gmail.sanfrancisco.repositorio.FacturaCostoVehiculoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class FacturaCostoVehiculoService extends ServicioModelo<FacturaCostoVehiculo> {
    @Inject
    public FacturaCostoVehiculoService(FacturaCostoVehiculoRepositorio repo) { this.repo = repo; }

    @Override
    public Stream<FacturaCostoVehiculo> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<FacturaCostoVehiculo> result = ((FacturaCostoVehiculoRepositorio)repo).findFiltered(offset, limit, likePattern(filtro));

        return result.getResultList().stream();
        //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((FacturaCostoVehiculoRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
