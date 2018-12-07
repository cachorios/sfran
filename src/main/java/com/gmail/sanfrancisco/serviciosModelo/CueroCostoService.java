package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.CueroCosto;
import com.gmail.sanfrancisco.repositorio.CueroCostoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class CueroCostoService extends ServicioModelo<CueroCosto> {
    @Inject
    public CueroCostoService(CueroCostoRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<CueroCosto> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<CueroCosto> result = ((CueroCostoRepositorio)repo).findFiltered( offset, limit);

        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((CueroCostoRepositorio) repo).countFiltered();
        return cnt;
    }
}