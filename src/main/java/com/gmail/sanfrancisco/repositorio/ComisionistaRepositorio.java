package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Comisionista;
import org.apache.deltaspike.data.api.*;

import java.sql.Date;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface ComisionistaRepositorio extends EntityRepository<Comisionista, Long>, EntityManagerDelegate<Comisionista> {

    @Query("SELECT e FROM Comisionista e WHERE UPPER(e.nombre) like :filter")
    QueryResult<Comisionista> findFiltered(
            @FirstResult int offset,
            @MaxResults int limit,
            @QueryParam("filter") String filter);


    @Query("SELECT COUNT(e) FROM Comisionista e WHERE UPPER(e.nombre) like :filter")
    Long countFiltered(
            @QueryParam("filter") String filter);

    @Query("SELECT SUM(e.totalComisionista + e.importeEntrega - e.ajustes) haber FROM Dte e WHERE e.comisionista = :comisionista AND e.fechaCarga >= :fechaInicio AND e.fechaCarga < :fecha")
    Double saldoAnteriorCabezera(
            @QueryParam("comisionista") Comisionista comisionista,
            @QueryParam("fechaInicio") Date fechaInicio,
            @QueryParam("fecha") Date fecha);

    @Query("SELECT SUM((f.precioKgVivo * f.kgVivo) + ((f.precioKgVivo * f.kgVivo * f.porcentajeComision)/100)) debe FROM Dte e JOIN e.categorias f WHERE e.comisionista = :comisionista AND e.fechaCarga >= :fechaInicio AND e.fechaCarga < :fecha")
    Double saldoAnteriorDetalle(
            @QueryParam("comisionista") Comisionista comisionista,
            @QueryParam("fechaInicio") Date fechaInicio,
            @QueryParam("fecha") Date fecha);
}
