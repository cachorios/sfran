package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface VehiculoCostoInsumoRepositorio extends EntityRepository<VehiculoCostoInsumo, Long>, EntityManagerDelegate<VehiculoCostoInsumo> {

    @Query("SELECT e FROM VehiculoCostoInsumo e WHERE e.nombre like :filter")
    QueryResult<VehiculoCostoInsumo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);


    @Query("SELECT COUNT(e) FROM VehiculoCostoInsumo e WHERE e.nombre like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
