package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface InsumoCostoVehiculoRepositorio extends EntityRepository<InsumoCostoVehiculo, Long>, EntityManagerDelegate<InsumoCostoVehiculo> {

    @Query("SELECT e FROM InsumoCostoVehiculo e WHERE e.nombre like :filter")
    QueryResult<InsumoCostoVehiculo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);


    @Query("SELECT COUNT(e) FROM InsumoCostoVehiculo e WHERE e.nombre like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
