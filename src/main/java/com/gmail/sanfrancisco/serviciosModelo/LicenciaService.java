package com.gmail.sanfrancisco.serviciosModelo;

import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.gmail.sanfrancisco.repositorio.LicenciaRepositorio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class LicenciaService extends ServicioModelo<Licencia> {
    @Inject
    public LicenciaService(LicenciaRepositorio repo) {
        this.repo = repo;
    }


    @Override
    public Stream<Licencia> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
        QueryResult<Licencia> result = ((LicenciaRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));


        return result.getResultList().stream();
        //QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;
        cnt = ((LicenciaRepositorio) repo).countFiltered(likePattern(filtro));
        return cnt;
    }
}
