package com.gmail.cacho.backend.service;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.backend.repositorios.ParametrosRepositorio;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

public class ParamVariosServicio  extends ServicioModelo<Parametro> {
    @Inject
    private ParametrosRepositorio repo;
    public ParamVariosServicio() {
    }

    public Stream<Parametro> findAnyMatching(ETipoParametro tipo, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Parametro> result;
        result = repo.queryAliveByTipoAndClaseNombreLike(tipo, filtro);
        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }
    public long countAnyMatchingVarios(ETipoParametro tipo, String filtro) {
        return repo.countAliveByTipoAndClaseNombreLike(tipo, filtro);
    }


    /**
     *  EStos dos mettodos  es solo para cumplimentar la herencia
     *
     */
    @Override
    public Stream<Parametro> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        return null;
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        return 0;
    }
}
