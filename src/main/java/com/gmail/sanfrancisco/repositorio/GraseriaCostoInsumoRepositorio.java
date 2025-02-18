package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface GraseriaCostoInsumoRepositorio extends EntityRepository<GraseriaCostoInsumo, Long>, EntityManagerDelegate<GraseriaCostoInsumo> {

    @Query("SELECT e FROM GraseriaCostoInsumo e")
    QueryResult<GraseriaCostoInsumo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit);
//            @QueryParam("filter") String filter);

    @Query("SELECT  COUNT(e) FROM GraseriaCostoInsumo e")
    Long countFiltered();
//            @QueryParam("filter") String filter);
}