package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.FaenaCabezera;
import com.gmail.sanfrancisco.repositorio.FaenaCabezeraRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class FaenaCabezeraService extends ServicioModelo<FaenaCabezera> {
    @Inject
    public FaenaCabezeraService(FaenaCabezeraRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<FaenaCabezera> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<FaenaCabezera> result = ((FaenaCabezeraRepositorio)repo).findFiltered( offset, limit);

        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((FaenaCabezeraRepositorio) repo).countFiltered();
        return cnt;
    }
}