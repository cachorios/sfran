package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.Graseria;
import com.gmail.sanfrancisco.repositorio.GraseriaRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class GraseriaService extends ServicioModelo<Graseria> {
    @Inject
    public GraseriaService(GraseriaRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<Graseria> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Graseria> result = ((GraseriaRepositorio)repo).findFiltered( offset, limit);


        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((GraseriaRepositorio) repo).countFiltered();
        return cnt;
    }
}