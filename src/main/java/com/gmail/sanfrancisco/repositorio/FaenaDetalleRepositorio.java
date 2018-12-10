package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.FaenaDetalle;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface FaenaDetalleRepositorio extends EntityRepository<FaenaDetalle, Long>, EntityManagerDelegate<FaenaDetalle> {
    @Query("SELECT e FROM FaenaDetalle e")
    QueryResult<FaenaDetalle> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit);

    @Query("SELECT  COUNT(e) FROM FaenaDetalle e")
    Long countFiltered();
}
