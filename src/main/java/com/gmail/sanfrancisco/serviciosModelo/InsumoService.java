package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.gmail.sanfrancisco.repositorio.InsumoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class InsumoService extends ServicioModelo<Insumo> {
    @Inject
    public InsumoService(InsumoRepositorio repo) { this.repo = repo; }

    @Override
    public Stream<Insumo> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Insumo> result = ((InsumoRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));

        return result.getResultList().stream();
                //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((InsumoRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
