package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Insumo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface InsumoRepositorio extends EntityRepository<Insumo, Long>, EntityManagerDelegate<Insumo> {

    @Query("SELECT e FROM Insumo e WHERE e.descripcion like :filter")
    QueryResult<Insumo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(e) FROM Insumo e WHERE e.descripcion like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
