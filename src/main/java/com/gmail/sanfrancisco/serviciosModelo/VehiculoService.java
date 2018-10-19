package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.gmail.sanfrancisco.repositorio.VehiculoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

public class VehiculoService extends ServicioModelo<Vehiculo> {
    @Inject
    public VehiculoService(VehiculoRepositorio repo) { this.repo = repo; }

    @Override
    public Stream<Vehiculo> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Vehiculo> result = ((VehiculoRepositorio)repo).findFiltered(offset, limit, likePattern(filtro));

        return result.getResultList().stream();
                //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((VehiculoRepositorio)repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
