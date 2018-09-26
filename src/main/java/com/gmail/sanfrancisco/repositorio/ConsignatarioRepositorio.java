package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Consignatario;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface ConsignatarioRepositorio extends EntityRepository<Consignatario, Long>, EntityManagerDelegate<Consignatario> {

    @Query("SELECT u FROM Consignatario u WHERE u.descripcion like :filter")
    QueryResult<Consignatario> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(u) FROM Consignatario u WHERE u.descripcion like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
