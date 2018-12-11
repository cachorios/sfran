package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.repositorio.DteRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class DteService extends ServicioModelo<Dte> {
    @Inject
    public DteService(DteRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<Dte> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Dte> result = ((DteRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));


        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((DteRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }

    public Dte getDteByNumeroTropa(String numerotropa){
        return ((DteRepositorio) repo).findByNumeroTropa(numerotropa);
    }
}