package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumo;
import com.gmail.sanfrancisco.repositorio.CueroCostoInsumoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class CueroCostoInsumoService extends ServicioModelo<CueroCostoInsumo> {
    @Inject
    public CueroCostoInsumoService(CueroCostoInsumoRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<CueroCostoInsumo> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<CueroCostoInsumo> result = ((CueroCostoInsumoRepositorio)repo).findFiltered( offset, limit);


        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((CueroCostoInsumoRepositorio) repo).countFiltered();
        return cnt;
    }
}