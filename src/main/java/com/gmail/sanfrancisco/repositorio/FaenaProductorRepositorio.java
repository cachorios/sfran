package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.FaenaProductor;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface FaenaProductorRepositorio extends EntityRepository<FaenaProductor, Long>, EntityManagerDelegate<FaenaProductor> {
    @Query("SELECT e FROM FaenaProductor e")
    QueryResult<FaenaProductor> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit);

    @Query("SELECT  COUNT(e) FROM FaenaProductor e")
    Long countFiltered();
}
