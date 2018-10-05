package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.gmail.sanfrancisco.repositorio.RenspaRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

public class RenspaService extends ServicioModelo<Renspa> {
    @Inject
    public RenspaService(RenspaRepositorio repo) { this.repo = repo; }

    @Override
    public Stream<Renspa> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Renspa> result = ((RenspaRepositorio)repo).findFiltered(offset,limit,likePattern(filtro));

        return result.getResultList().stream();
        //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt =((RenspaRepositorio)repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
