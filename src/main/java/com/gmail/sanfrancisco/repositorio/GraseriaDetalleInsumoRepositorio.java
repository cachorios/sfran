package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.GraseriaDetalleInsumo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface GraseriaDetalleInsumoRepositorio extends EntityRepository<GraseriaDetalleInsumo, Long>, EntityManagerDelegate<GraseriaDetalleInsumo> {

    @Query("SELECT e FROM GraseriaDetalleInsumo e WHERE e.numeroTropa like :filter")
    QueryResult<GraseriaDetalleInsumo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT  COUNT(e) FROM GraseriaDetalleInsumo e WHERE e.numeroTropa like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}