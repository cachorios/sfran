package com.gmail.cacho.backend.repositorios;

import com.gmail.cacho.backend.entidad.Usuario;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface Usuarios  extends EntityRepository<Usuario, Long>, EntityManagerDelegate<Usuario> {
    Usuario findByUsername(String username);
    Usuario findByEmail(String email);


    @Query("SELECT u FROM Usuario u WHERE u.username like :filter")
    QueryResult<Usuario> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

}
