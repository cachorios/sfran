package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumoImpuesto;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface GraseriaCostoInsumoImpuestoRepositorio extends EntityRepository<GraseriaCostoInsumoImpuesto, Long>, EntityManagerDelegate<GraseriaCostoInsumoImpuesto> {

    @Query("SELECT e FROM GraseriaCostoInsumoImpuesto e WHERE e.numeroTropa like :filter")
    QueryResult<GraseriaCostoInsumoImpuesto> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);

    @Query("SELECT  COUNT(e) FROM GraseriaCostoInsumoImpuesto e WHERE e.numeroTropa like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}