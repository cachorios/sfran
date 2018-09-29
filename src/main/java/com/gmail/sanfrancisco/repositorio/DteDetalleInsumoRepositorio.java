package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface DteDetalleInsumoRepositorio extends EntityRepository<DteDetalleInsumo, Long>, EntityManagerDelegate<DteDetalleInsumo> {

    @Query("SELECT u FROM DteDetalleInsumo u WHERE u.nombre like :filter")
    QueryResult<DteDetalleInsumo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(u) FROM DteDetalleInsumo u WHERE u.nombre like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}