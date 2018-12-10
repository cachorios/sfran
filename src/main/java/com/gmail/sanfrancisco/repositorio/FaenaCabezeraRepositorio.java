package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.FaenaCabezera;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface FaenaCabezeraRepositorio extends EntityRepository<FaenaCabezera, Long>, EntityManagerDelegate<FaenaCabezera> {
    @Query("SELECT e FROM FaenaCabezera e")
    QueryResult<FaenaCabezera> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit);

    @Query("SELECT  COUNT(e) FROM FaenaCabezera e")
    Long countFiltered();
}
