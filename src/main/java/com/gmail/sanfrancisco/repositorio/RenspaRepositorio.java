package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Renspa;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface RenspaRepositorio extends EntityRepository<Renspa, Long>, EntityManagerDelegate<Renspa> {

    @Query("SELECT u FROM Renspa")
    QueryResult<Renspa> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(u) FROM Renspa")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
