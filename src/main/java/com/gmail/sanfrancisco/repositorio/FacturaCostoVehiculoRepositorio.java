package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.FacturaCostoVehiculo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface FacturaCostoVehiculoRepositorio extends EntityRepository<FacturaCostoVehiculo, Long>, EntityManagerDelegate<FacturaCostoVehiculo> {

    @Query("SELECT e FROM FacturaCostoVehiculo e")
    QueryResult<FacturaCostoVehiculo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);


    @Query("SELECT COUNT(e) FROM FacturaCostoVehiculo e")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
