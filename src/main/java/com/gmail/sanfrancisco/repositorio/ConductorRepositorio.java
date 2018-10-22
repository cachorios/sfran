package com.gmail.sanfrancisco.repositorio;


import com.gmail.sanfrancisco.entidad.Conductor;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface ConductorRepositorio extends EntityRepository<Conductor, Long>, EntityManagerDelegate<Conductor> {

    @Query("SELECT e FROM Conductor e WHERE e.nombre like :filter")
    QueryResult<Conductor> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(e) FROM Conductor e WHERE e.nombre like :filter")
    Long countFiltered(
           @QueryParam("filter") String filter);
}




