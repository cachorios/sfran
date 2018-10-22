package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Vehiculo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface VehiculoRepositorio extends EntityRepository<Vehiculo, Long>, EntityManagerDelegate<Vehiculo> {

    @Query("SELECT e FROM Vehiculo e WHERE e.dominio like :filter")
    QueryResult<Vehiculo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(e) FROM Vehiculo e WHERE e.dominio like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
