package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.gmail.sanfrancisco.repositorio.DteDetalleCategoriaRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class DteDetalleCategoriaService extends ServicioModelo<DteDetalleCategoria> {
    @Inject
    public DteDetalleCategoriaService(DteDetalleCategoriaRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<DteDetalleCategoria> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<DteDetalleCategoria> result = ((DteDetalleCategoriaRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));


        return result.getResultList().stream();
        //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((DteDetalleCategoriaRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
