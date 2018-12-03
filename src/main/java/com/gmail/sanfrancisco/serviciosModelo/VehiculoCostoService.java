package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.VehiculoCosto;
import com.gmail.sanfrancisco.repositorio.VehiculoCostoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class VehiculoCostoService extends ServicioModelo<VehiculoCosto> {
    @Inject
    public VehiculoCostoService(VehiculoCostoRepositorio repo) { this.repo = repo; }

    @Override
    public Stream<VehiculoCosto> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<VehiculoCosto> result = ((VehiculoCostoRepositorio)repo).findFiltered(offset, limit);

        //return result.getResultList().stream();
        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((VehiculoCostoRepositorio) repo).countFiltered();
        return cnt;
    }
}
