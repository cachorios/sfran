package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.NumeroDte;
import com.gmail.sanfrancisco.repositorio.NumeroDteRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

public class NumeroDteService extends ServicioModelo<NumeroDte> {
    @Inject
    public NumeroDteService(NumeroDteRepositorio repo) { this.repo = repo; }

    @Override
    public Stream<NumeroDte> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<NumeroDte> result = ((NumeroDteRepositorio)repo).findFiltered(offset,limit,likePattern(filtro));

        return result.getResultList().stream();
                //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt =((NumeroDteRepositorio)repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
