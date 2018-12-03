package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumoImpuesto;
import com.gmail.sanfrancisco.repositorio.GraseriaCostoInsumoImpuestoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class GraseriaCostoInsumoImpuestoService extends ServicioModelo<GraseriaCostoInsumoImpuesto> {
    @Inject
    public GraseriaCostoInsumoImpuestoService(GraseriaCostoInsumoImpuestoRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<GraseriaCostoInsumoImpuesto> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<GraseriaCostoInsumoImpuesto> result = ((GraseriaCostoInsumoImpuestoRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));


        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((GraseriaCostoInsumoImpuestoRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}