package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.ImpuestoCostoVehiculo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface ImpuestoCostoVehiculoRepositorio extends EntityRepository<ImpuestoCostoVehiculo, Long>, EntityManagerDelegate<ImpuestoCostoVehiculo> {

    @Query("SELECT e FROM ImpuestoCostoVehiculo e WHERE e.nombre like :filter")
    QueryResult<ImpuestoCostoVehiculo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);


    @Query("SELECT COUNT(e) FROM ImpuestoCostoVehiculo e WHERE e.nombre like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
