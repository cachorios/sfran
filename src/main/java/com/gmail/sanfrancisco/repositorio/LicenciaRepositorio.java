package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Licencia;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface LicenciaRepositorio extends EntityRepository<Licencia, Long>, EntityManagerDelegate<Licencia> {

    @Query("SELECT e FROM Licencia e")
    QueryResult<Licencia> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(e) FROM Licencia e")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
