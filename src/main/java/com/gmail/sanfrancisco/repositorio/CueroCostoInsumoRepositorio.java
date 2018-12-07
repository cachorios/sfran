package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.CueroCostoInsumo;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface CueroCostoInsumoRepositorio extends EntityRepository<CueroCostoInsumo, Long>, EntityManagerDelegate<CueroCostoInsumo> {

    @Query("SELECT e FROM CueroCostoInsumo e")
    QueryResult<CueroCostoInsumo> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit);
//            @QueryParam("filter") String filter);

    @Query("SELECT  COUNT(e) FROM CueroCostoInsumo e")
    Long countFiltered();
//            @QueryParam("filter") String filter);
}