package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.ImpuestoCostoVehiculo;
import com.gmail.sanfrancisco.repositorio.ImpuestoCostoVehiculoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class ImpuestoCostoVehiculoService extends ServicioModelo<ImpuestoCostoVehiculo> {
    @Inject
    public ImpuestoCostoVehiculoService(ImpuestoCostoVehiculoRepositorio repo) { this.repo = repo; }

    @Override
    public Stream<ImpuestoCostoVehiculo> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<ImpuestoCostoVehiculo> result = ((ImpuestoCostoVehiculoRepositorio)repo).findFiltered(offset, limit, likePattern(filtro));

        return result.getResultList().stream();
        //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((ImpuestoCostoVehiculoRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}