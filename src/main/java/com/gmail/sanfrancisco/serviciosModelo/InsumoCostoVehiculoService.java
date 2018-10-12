package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;
import com.gmail.sanfrancisco.repositorio.InsumoCostoVehiculoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class InsumoCostoVehiculoService extends ServicioModelo<InsumoCostoVehiculo> {
    @Inject
    public InsumoCostoVehiculoService(InsumoCostoVehiculoRepositorio repo) { this.repo = repo; }

    @Override
    public Stream<InsumoCostoVehiculo> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<InsumoCostoVehiculo> result = ((InsumoCostoVehiculoRepositorio)repo).findFiltered(offset, limit, likePattern(filtro));

        return result.getResultList().stream();
        //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((InsumoCostoVehiculoRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}