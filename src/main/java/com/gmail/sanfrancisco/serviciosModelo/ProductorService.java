package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Productor;
import com.gmail.sanfrancisco.repositorio.ProductorRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class ProductorService extends ServicioModelo<Productor> {
    @Inject
    public ProductorService(ProductorRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<Productor> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Productor> result = ((ProductorRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));


        return result.getResultList().stream();
        //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((ProductorRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
