package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.GraseriaCosto;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface GraseriaCostoRepositorio extends EntityRepository<GraseriaCosto, Long>, EntityManagerDelegate<GraseriaCosto> {

    @Query("SELECT e FROM GraseriaCosto e")
    QueryResult<GraseriaCosto> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit
//            @QueryParam("filter") String filter);
    );

    @Query("SELECT  COUNT(e) FROM GraseriaCosto e")
    Long countFiltered();
//            @QueryParam("filter") String filter);
}