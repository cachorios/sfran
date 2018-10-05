package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Comisionista;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface ComisionistaRepositorio extends EntityRepository<Comisionista, Long>, EntityManagerDelegate<Comisionista> {

    @Query("SELECT u FROM Comisionista u WHERE u.nombre like :filter")
    QueryResult<Comisionista> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);


    @Query("SELECT COUNT(u) FROM Comisionista u WHERE u.nombre like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
