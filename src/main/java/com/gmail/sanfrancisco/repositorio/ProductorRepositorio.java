package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Productor;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface ProductorRepositorio extends EntityRepository<Productor, Long>, EntityManagerDelegate<Productor> {

    @Query("SELECT e FROM Productor e WHERE UPPER(e.nombre) like :filter")
    QueryResult<Productor> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(e) FROM Productor e WHERE UPPER(e.nombre) like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
