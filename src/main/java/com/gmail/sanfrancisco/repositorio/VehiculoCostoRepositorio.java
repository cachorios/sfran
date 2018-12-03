package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.VehiculoCosto;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface VehiculoCostoRepositorio extends EntityRepository<VehiculoCosto, Long>, EntityManagerDelegate<VehiculoCosto> {

    @Query("SELECT e FROM VehiculoCosto e")
    QueryResult<VehiculoCosto> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit
//            @QueryParam("filter") String filter);
    );

    @Query("SELECT COUNT(e) FROM VehiculoCosto e")
    Long countFiltered();
//            @QueryParam("filter") String filter);
}
