package com.gmail.cacho.backend.service;


import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.backend.repositorios.ParametrosRepositorio;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class ParametroServicio extends ServicioModelo<Parametro> {

    @Inject
    private ParametrosRepositorio repo;


        public Parametro findByTipoAndOrden(ETipoParametro tipo, Integer orden) {
        return repo.findByTipoAndOrden(tipo, orden);
    }

    public List<Parametro> findByClaseLikeAndValorintOrderByOrden(String clase, Long valorint) {
        return repo.findByClaseLikeAndValorintOrderByOrden(clase, valorint);
    }

    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;

        if (padre != null) {
            if (padre instanceof ETipoParametro) {
                if (filtro != null) {
                    cnt = ((ParametrosRepositorio) repo)
                            .countAliveByTipoAndClaseNombreLike((ETipoParametro) padre, '%' + filtro.toLowerCase() + '%');
                } else {
                    cnt = ((ParametrosRepositorio) repo).countAliveByTipo((ETipoParametro) padre);
                }
            }
        } else if (filtro != null) {
            cnt = ((ParametrosRepositorio) repo).countWithFilter('%' + filtro.toLowerCase() + '%');
        } else {
            cnt = ((ParametrosRepositorio) repo).countAll();
        }

        return cnt;
    }


    public Stream<Parametro> findAnyMatching(Object padre, String filtro, int offset, int limitm,
                                             List<QuerySortOrder> sortOrders) {
        QueryResult<Parametro> result = null;

        if (padre != null) {
            if (padre instanceof ETipoParametro) {
                if (filtro != null) {
                    result = ((ParametrosRepositorio) repo)
                            .queryAliveByTipoAndClaseNombreLike((ETipoParametro) padre, '%' + filtro.toLowerCase() + '%');
                } else {
                    result = ((ParametrosRepositorio) repo).queryAliveByTipo((ETipoParametro) padre);
                }
            }
        } else if (filtro != null) {
            result = ((ParametrosRepositorio) repo).findWithFilter('%' + filtro.toLowerCase() + '%');
        } else {
            result = ((ParametrosRepositorio) repo).queryAll();
        }

        return QueryHelper.applyLimitsAndSortOrder(result, offset, limitm, sortOrders).getResultList().stream();
    }

    public Stream<Parametro> findAnyMatching(Object padre, Long grupo , String filtro, int offset, int limitm,
                                             List<QuerySortOrder> sortOrders) {
        QueryResult<Parametro> result = null;

        if (padre != null) {
            if (padre instanceof ETipoParametro) {
                result = ((ParametrosRepositorio) repo)
                        .queryTipoAndGrupoandFilter((ETipoParametro) padre, likePattern(grupo.toString()), likePattern(filtro));
            }

        } else {
            result = ((ParametrosRepositorio) repo).queryAll();
        }

        return QueryHelper.applyLimitsAndSortOrder(result, offset, limitm, sortOrders).getResultList().stream();
    }

    public Long countAnyMatching(Object padre, Long grupo , String filtro, int offset, int limitm,
                                             List<QuerySortOrder> sortOrders) {
        return findAnyMatching(padre, grupo, filtro, offset, limitm, sortOrders).count();

    }

}
