package com.gmail.sanfrancisco.repositorio;


import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface DteDetalleCategoriaRepositorio extends EntityRepository<DteDetalleCategoria, Long>, EntityManagerDelegate<DteDetalleCategoria> {

    @Query("SELECT e FROM DteDetalleCategoria e")
    QueryResult<DteDetalleCategoria> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit //,
//            @QueryParam("filter") String filter
    ) ;

    @Query("SELECT COUNT(e) FROM DteDetalleCategoria e")
    Long countFiltered();
            //@QueryParam("filter") String filter);
}