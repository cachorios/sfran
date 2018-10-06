package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.DteDetalleImpuesto;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface DteDetalleImpuestoRepositorio extends EntityRepository<DteDetalleImpuesto, Long>, EntityManagerDelegate<DteDetalleImpuesto> {

    @Query("SELECT u FROM DteDetalleInsumo u WHERE u.nombre like :filter")
    QueryResult<DteDetalleImpuesto> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(u) FROM DteDetalleInsumo u WHERE u.nombre like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}