package com.gmail.cacho.backend.repositorios;

import com.gmail.cacho.backend.entidad.Parametro;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import org.apache.deltaspike.data.api.*;

import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface ParametrosRepositorio extends EntityRepository<Parametro, Long>, EntityManagerDelegate<Parametro> {

    @Query("SELECT e FROM parametro e WHERE e.tipo = ?1 AND e.fechabaja IS NULL AND (LOWER(e.clase) LIKE ?2 OR LOWER(e.nombre) LIKE ?2)")
    QueryResult<Parametro> queryAliveByTipoAndClaseNombreLike(ETipoParametro tipo, String like);

    @Query("SELECT COUNT(e) FROM parametro e WHERE e.tipo = ?1 AND e.fechabaja IS NULL AND (LOWER(e.clase) LIKE ?2 OR LOWER(e.nombre) LIKE ?2)")
    Long countAliveByTipoAndClaseNombreLike(ETipoParametro tipo, String like);

    @Query("SELECT e FROM parametro e WHERE e.tipo = ?1 AND e.fechabaja IS NULL")
    QueryResult<Parametro> queryAliveByTipo(ETipoParametro tipo);

    @Query("SELECT COUNT(e) FROM parametro e WHERE e.tipo = ?1 AND e.fechabaja IS NULL")
    Long countAliveByTipo(ETipoParametro tipo);

    Parametro findByTipoAndOrden(ETipoParametro tipo, Integer orden);

    List<Parametro> findByClaseLikeAndValorintOrderByOrden(String claseLike, Long orden);

    @Query("SELECT e FROM parametro e WHERE e.clase=?1 AND e.nombre=?2 AND e.fechabaja IS null")
    Parametro findOneAliveByClaseAndNombre(String clase, String nombre);

    @Query("SELECT e FROM parametro e WHERE (LOWER( e.clase ) LIKE ?1 OR LOWER( e.nombre ) LIKE ?1 ) AND e.fechabaja IS null")
    QueryResult<Parametro> findWithFilter(String filtro);

    @Query("SELECT COUNT(e) FROM parametro e WHERE (LOWER( e.clase ) LIKE ?1 OR LOWER( e.nombre ) LIKE ?1 ) AND e.fechabaja IS null")
    Long countWithFilter(String filtro);

    @Query("SELECT e FROM parametro e WHERE e.fechabaja IS null")
    QueryResult<Parametro> queryAll();

    @Query("SELECT COUNT(e) FROM parametro e WHERE e.fechabaja IS null")
    Long countAll();
}
