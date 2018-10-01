package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Productor;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface ProductorRepositorio extends EntityRepository<Productor, Long>, EntityManagerDelegate<Productor> {

    @Query("SELECT u FROM Productor u WHERE u.nombre like :filter")
    QueryResult<Productor> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(u) FROM Productor u WHERE u.nombre like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
