package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.entidad.Productor;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface DteRepositorio extends EntityRepository<Dte, Long>, EntityManagerDelegate<Dte> {

    @Query("SELECT e FROM Dte e WHERE e.numeroTropa like :filter")
    QueryResult<Dte> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT DISTINCT e FROM Dte e JOIN e.categorias f WHERE f.productor = :productor")
    QueryResult<Dte> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("productor") Productor productor);

    @Query("SELECT  COUNT(e) FROM Dte e WHERE e.numeroTropa like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);

    @Query("SELECT DISTINCT COUNT(e) FROM Dte e JOIN e.categorias f WHERE f.productor = :productor")
    Long countFiltered(
            @QueryParam("productor") Productor productor);

    @Query("SELECT  COUNT(e) FROM Dte e WHERE e.id = :filter")
    Long countFiltered(
            @QueryParam("filter") Long filter);

    @Query("SELECT DISTINCT e FROM Dte e JOIN e.categorias f WHERE e.numeroTropa = :numerotropa AND f.productor = :productor")
    Dte findByNumeroTropa(
            @QueryParam("numerotropa") String numerotropa,
            @QueryParam("productor") Productor productor);
}
