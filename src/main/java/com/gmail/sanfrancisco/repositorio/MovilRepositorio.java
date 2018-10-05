package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Movil;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface MovilRepositorio extends EntityRepository<Movil, Long>, EntityManagerDelegate<Movil> {

    @Query("SELECT u FROM Movil u WHERE u.dominio like :filter")
    QueryResult<Movil> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(u) FROM Movil u WHERE u.dominio like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
