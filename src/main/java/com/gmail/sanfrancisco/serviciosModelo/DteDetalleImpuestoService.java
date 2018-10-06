package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.DteDetalleImpuesto;
import com.gmail.sanfrancisco.repositorio.DteDetalleImpuestoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class DteDetalleImpuestoService extends ServicioModelo<DteDetalleImpuesto> {
    @Inject
    public DteDetalleImpuestoService(DteDetalleImpuestoRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<DteDetalleImpuesto> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<DteDetalleImpuesto> result = ((DteDetalleImpuestoRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));


        return result.getResultList().stream();
        //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((DteDetalleImpuestoRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
