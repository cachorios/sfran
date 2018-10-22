package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.NumeroDte;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface NumeroDteRepositorio extends EntityRepository<NumeroDte, Long>, EntityManagerDelegate<NumeroDte> {

    @Query("SELECT e FROM NumeroDte")
    QueryResult<NumeroDte> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(e) FROM NumeroDte")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
