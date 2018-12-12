package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.entidad.Productor;
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

    public long countAnyMatching(Object padre, Productor productor) {
        Long cnt = null;
        cnt = ((DteRepositorio) repo).countFiltered(productor);
        return cnt;
    }

    public Stream<Dte> findAnyMatching(Object padre, Productor productor, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Dte> result = ((DteRepositorio)repo).findFiltered( offset, limit, productor);


        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((DteRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }

    public Dte getDteByNumeroTropa(String numerotropa, Productor productor){
        return ((DteRepositorio) repo).findByNumeroTropa(numerotropa, productor);
    }

    /*public Stream<Dte> findByProductor(Object padre, Productor productor, List<QuerySortOrder> sortOrders) {
        QueryResult<Dte> result = ((DteRepositorio)repo).QueryResultByProductor( productor);


        return result.getResultList().stream();
    }*/
}