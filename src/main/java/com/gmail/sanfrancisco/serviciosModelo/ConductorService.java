package com.gmail.sanfrancisco.serviciosModelo;


import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.gmail.sanfrancisco.repositorio.ConductorRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class ConductorService extends ServicioModelo<Conductor> {
    @Inject
    public ConductorService(ConductorRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<Conductor> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Conductor> result = ((ConductorRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));


        return result.getResultList().stream();
                //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((ConductorRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
