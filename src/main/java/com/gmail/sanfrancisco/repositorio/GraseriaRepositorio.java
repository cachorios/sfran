package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Graseria;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface GraseriaRepositorio extends EntityRepository<Graseria, Long>, EntityManagerDelegate<Graseria> {

    @Query("SELECT e FROM Graseria WHERE e.numeroTropa like :filter")
    QueryResult<Graseria> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT  COUNT(e) FROM Graseria e WHERE e.numeroTropa like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}