package com.gmail.sanfrancisco.repositorio;


import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface DteDetalleCategoriaRepositorio extends EntityRepository<DteDetalleCategoria, Long>, EntityManagerDelegate<DteDetalleCategoria> {

    @Query("SELECT u FROM DteDetalleCategoria u")
    QueryResult<DteDetalleCategoria> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(u) FROM DteDetalleCategoria u")
    Long countFiltered(
            @QueryParam("filter") String filter);
}