package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumoImpuesto;
import com.gmail.sanfrancisco.repositorio.CueroCostoInsumoImpuestoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class CueroCostoInsumoImpuestoService extends ServicioModelo<CueroCostoInsumoImpuesto> {
    @Inject
    public CueroCostoInsumoImpuestoService(CueroCostoInsumoImpuestoRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<CueroCostoInsumoImpuesto> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<CueroCostoInsumoImpuesto> result = ((CueroCostoInsumoImpuestoRepositorio)repo).findFiltered( offset, limit);


        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((CueroCostoInsumoImpuestoRepositorio) repo).countFiltered();
        return cnt;
    }
}