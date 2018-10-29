package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleInsumo;
import com.gmail.sanfrancisco.repositorio.GraseriaDetalleInsumoRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class GraseriaDetalleInsumoService extends ServicioModelo<GraseriaDetalleInsumo> {
    @Inject
    public GraseriaDetalleInsumoService(GraseriaDetalleInsumoRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<GraseriaDetalleInsumo> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<GraseriaDetalleInsumo> result = ((GraseriaDetalleInsumoRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));


        return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((GraseriaDetalleInsumoRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}