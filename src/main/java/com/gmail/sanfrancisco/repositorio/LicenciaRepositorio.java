package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Licencia;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface LicenciaRepositorio extends EntityRepository<Licencia, Long>, EntityManagerDelegate<Licencia> {

    @Query("SELECT u FROM Licencia u")
    QueryResult<Licencia> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(u) FROM Licencia u")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
