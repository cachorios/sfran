package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Faena;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface FaenaRepositorio extends EntityRepository<Faena, Long>, EntityManagerDelegate<Faena> {
    @Query("SELECT e FROM Faena e")
    QueryResult<Faena> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit);

    @Query("SELECT  COUNT(e) FROM Faena e")
    Long countFiltered();
}
