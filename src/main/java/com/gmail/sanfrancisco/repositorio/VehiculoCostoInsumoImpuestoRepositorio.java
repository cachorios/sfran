package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumoImpuesto;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface VehiculoCostoInsumoImpuestoRepositorio extends EntityRepository<VehiculoCostoInsumoImpuesto, Long>, EntityManagerDelegate<VehiculoCostoInsumoImpuesto> {

    @Query("SELECT e FROM VehiculoCostoInsumoImpuesto e WHERE e.nombre like :filter")
    QueryResult<VehiculoCostoInsumoImpuesto> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);


    @Query("SELECT COUNT(e) FROM VehiculoCostoInsumoImpuesto e WHERE e.nombre like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);
}
