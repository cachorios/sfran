package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.gmail.sanfrancisco.repositorio.ConsignatarioRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class ConsignatarioService extends ServicioModelo<Consignatario> {
    @Inject
    public ConsignatarioService(ConsignatarioRepositorio repo) { this.repo = repo; }

    @Override
    public Stream<Consignatario> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Consignatario> result = ((ConsignatarioRepositorio)repo).findFiltered(offset, limit, likePattern(filtro));

        return result.getResultList().stream();
                //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((ConsignatarioRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
