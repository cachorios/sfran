package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.GraseriaDetalleImpuesto;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface GraseriaDetalleImpuestoRepositorio extends EntityRepository<GraseriaDetalleImpuesto, Long>, EntityManagerDelegate<GraseriaDetalleImpuesto> {

    @Query("SELECT e FROM GraseriaDetalleImpuesto e WHERE e.numeroTropa like :filter")
    QueryResult<GraseriaDetalleImpuesto> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT  COUNT(e) FROM GraseriaDetalleImpuesto e WHERE e.numeroTropa like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}