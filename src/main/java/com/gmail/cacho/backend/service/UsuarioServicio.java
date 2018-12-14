package com.gmail.cacho.backend.service;

import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.backend.repositorios.UsuariosRepositorio;
import com.gmail.cacho.slapi.comunes.QueryHelper;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class UsuarioServicio extends ServicioModelo<Usuario> {
    @Inject
    public UsuarioServicio(UsuariosRepositorio repo) {
        this.repo = repo;
    }

    public Usuario findById(Long id) {
        return ((UsuariosRepositorio) repo).findById(id);
    }

    public Usuario findByUsername(String usename) {
        return ((UsuariosRepositorio) repo).findByUsername(usename);
    }

    public String getPasswordString(Long userId) {
        return ((UsuariosRepositorio) repo).getPasswordString(userId);
    }

    @Override
    public Stream<Usuario> findAnyMatching(Object padre, String filtro, int offset, int limitm,
                                           List<QuerySortOrder> sortOrders) {
        QueryResult<Usuario> result = null;

        if (filtro != null) {
            String repoFilter = "%" + filtro.toLowerCase() + "%";
            result = ((UsuariosRepositorio) repo)
                    .findByNombreLikeIgnoreCaseOrUsernameLikeIgnoreCaseOrEmailLikeIgnoreCase(repoFilter,
                            repoFilter,
                            repoFilter
                            );
        } else {
            result = ((UsuariosRepositorio) repo).queryAll();
        }

        return QueryHelper
                .applyLimitsAndSortOrder(((result == null) ? ((UsuariosRepositorio) repo).queryAll() : result), offset, limitm,
                        sortOrders).getResultList().stream();
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        Long cnt = null;

        if (filtro != null) {
            String repoFilter = "%" + filtro.toLowerCase() + "%";
            cnt = ((UsuariosRepositorio) repo)
                    .countByNombreLikeIgnoreCaseOrUsernameLikeIgnoreCaseOrEmailLikeIgnoreCase(
                            repoFilter, repoFilter, repoFilter);

        } else {
            cnt = ((UsuariosRepositorio) repo).countAll();
        }

        return cnt;
    }
}