package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.CueroCostoInsumoImpuesto;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface CueroCostoInsumoImpuestoRepositorio extends EntityRepository<CueroCostoInsumoImpuesto, Long>, EntityManagerDelegate<CueroCostoInsumoImpuesto> {

    @Query("SELECT e FROM CueroCostoInsumoImpuesto e")
    QueryResult<CueroCostoInsumoImpuesto> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit);
//            @QueryParam("filter") String filter);

    @Query("SELECT  COUNT(e) FROM CueroCostoInsumoImpuesto e")
    Long countFiltered();
//            @QueryParam("filter") String filter);
}