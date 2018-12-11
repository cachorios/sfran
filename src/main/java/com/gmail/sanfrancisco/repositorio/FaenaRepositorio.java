package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.entidad.Faena;
import org.apache.deltaspike.data.api.*;

import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface FaenaRepositorio extends EntityRepository<Faena, Long>, EntityManagerDelegate<Faena> {
    @Query("SELECT e FROM Faena e")
    QueryResult<Faena> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit);

    @Query("SELECT  COUNT(e) FROM Faena e")
    Long countFiltered();

    @Query("select e, sum(coalesce(f.cantidad,0)) consumido from DteDetalleCategoria e "+
            "LEFT JOIN e.cabezeraFaenas f where  e.dte = :dte GROUP BY e" )
    List SaldoCategoria(@QueryParam("dte") Dte dte);

}
