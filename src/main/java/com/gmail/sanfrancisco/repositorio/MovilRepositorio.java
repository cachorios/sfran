package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Vehiculo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface MovilRepositorio extends EntityRepository<Vehiculo, Long>, EntityManagerDelegate<Vehiculo> {

    @Query("SELECT u FROM Vehiculo u WHERE u.dominio like :filter")
    QueryResult<Vehiculo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT COUNT(u) FROM Vehiculo u WHERE u.dominio like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
