package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.CueroCosto;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface CueroCostoRepositorio extends EntityRepository<CueroCosto, Long>, EntityManagerDelegate<CueroCosto> {

    @Query("SELECT e FROM CueroCosto e")
    QueryResult<CueroCosto> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit
//            @QueryParam("filter") String filter);
    );

    @Query("SELECT  COUNT(e) FROM CueroCosto e")
    Long countFiltered();
//            @QueryParam("filter") String filter);
}