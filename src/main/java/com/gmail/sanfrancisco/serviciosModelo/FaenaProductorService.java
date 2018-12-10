package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.FaenaProductor;
import com.gmail.sanfrancisco.repositorio.FaenaProductorRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class FaenaProductorService extends ServicioModelo<FaenaProductor> {
    @Inject
    public FaenaProductorService(FaenaProductorRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<FaenaProductor> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<FaenaProductor> result = ((FaenaProductorRepositorio)repo).findFiltered( offset, limit);

        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((FaenaProductorRepositorio) repo).countFiltered();
        return cnt;
    }
}
