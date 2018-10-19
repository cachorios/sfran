package com.gmail.cacho.backend.repositorios;

import com.gmail.cacho.backend.entidad.Usuario;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface UsuariosRepositorio extends EntityRepository<Usuario, Long>, EntityManagerDelegate<Usuario> {
    Usuario findByUsername(String username);
    Usuario findByEmail(String email);


    @Query("SELECT e FROM Usuario e WHERE e.username like :filter")
    QueryResult<Usuario> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

}
