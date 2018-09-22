package com.gmail.cacho.backend.dataprovider;

import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.jpa.DataProviderService;
import com.gmail.cacho.backend.jpa.SortOrder;
import com.gmail.cacho.backend.repositorios.UsuariosRepositorio;

import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UsuarioDatoProviderService implements DataProviderService<Usuario, String> {
    @Inject
    private UsuariosRepositorio repo;

    @Override
    public List<Usuario> fetch(int offset, int limit, List<SortOrder> sortBy, String filter) {
        QueryResult<Usuario> queryResult = repo.findFiltered( offset, limit, likePattern(filter));
        sortBy.forEach(order ->order.apply(queryResult));
        return queryResult.getResultList();
    }

    @Override
    public int count(String filter) {
        QueryResult<Usuario> queryResult = repo.findFiltered(
                0, 0, likePattern(filter));
        return (int) queryResult.count();
    }
    private String likePattern(String filter) {
        return "%" +filter + "%";
    }
}
