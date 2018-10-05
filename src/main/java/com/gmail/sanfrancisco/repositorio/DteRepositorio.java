package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Dte;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface DteRepositorio extends EntityRepository<Dte, Long>, EntityManagerDelegate<Dte> {

    @Query("SELECT u FROM Dte WHERE u.numeroTropa like :filter")
    QueryResult<Dte> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT  COUNT(u) FROM Dte u WHERE u.numeroTropa like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
