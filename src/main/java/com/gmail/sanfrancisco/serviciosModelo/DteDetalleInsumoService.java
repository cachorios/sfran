package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;
import com.gmail.sanfrancisco.repositorio.DteDetalleInsumoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class DteDetalleInsumoService extends ServicioModelo<DteDetalleInsumo> {
    @Inject
    public DteDetalleInsumoService(DteDetalleInsumoRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<DteDetalleInsumo> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<DteDetalleInsumo> result = ((DteDetalleInsumoRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));


        return result.getResultList().stream();
        //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((DteDetalleInsumoRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
