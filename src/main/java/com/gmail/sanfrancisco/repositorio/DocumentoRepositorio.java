package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Documento;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface DocumentoRepositorio extends EntityRepository<Documento, Long>, EntityManagerDelegate<Documento> {

    @Query("SELECT u FROM Documento u WHERE u.nombre like :filter")
    QueryResult<Documento> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(u) FROM Documento u WHERE u.nombre like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
