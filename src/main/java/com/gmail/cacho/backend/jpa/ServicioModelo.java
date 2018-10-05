package com.gmail.cacho.backend.jpa;



import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slbase.logging.L;
import com.gmail.cacho.slbase.persist.excepciones.EntityErrorException;
import com.gmail.cacho.slbase.persist.excepciones.PersistErrorException;
import com.vaadin.flow.data.provider.QuerySortOrder;

import com.vaadin.flow.data.provider.SortDirection;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.QueryResult;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Stream;

/**
 * Implementación de interfase IServicioModelo para un sistema con JPA(deltaspike)-PostgrSQL. Esta clase es
 * ademas la que se encuentra encargada de representar al EntityManager que se usa en la aplicacion para el
 * manejo de la persistencia contra una base de datos relacional y en funcion de las definiciones del modulo
 * Apache Deltaspike Data/JPA.
 *
 * @param <U>   El tipo de IEntidadAuditada que gestiona este servicio.
 * @author jmfragueiro
 * @version 20161011
 */
public abstract class ServicioModelo<U extends AbstractEntidad>  {
    protected EntityRepository<U, Long> repo;

    protected EntityRepository<U, Long> getRepository(){
        return repo;
    }


    public U save(U entidad) throws PersistErrorException {
        try {
            L.info((entidad.isNew() ? C.MSJ_DB_SAVEDATA : C.MSJ_DB_ALTERDATA), entidad.toString());
            entidad = repo.saveAndFlush(entidad);
            return entidad;
        } catch (Exception ex) {
            throw new PersistErrorException(C.MSJ_ERR_ATSAVEDATA, PersistenceExceptionUtil.verifyAndGenMessagePersistException(ex));
        }

    }


    public U refresh(U instancia) throws PersistErrorException {
        try {
            L.info(C.MSJ_DB_REFRESHDATA, instancia.toString());
            repo.refresh(instancia);
            return instancia;
        } catch (Exception ex) {
            throw new PersistErrorException(C.MSJ_ERR_ATREFRESHDATA, PersistenceExceptionUtil.verifyAndGenMessagePersistException(ex));
        }
    }

     public void delete( U entity) {
        if (entity == null) {
            throw new EntityNotFoundException();
        }
//        entity.
        repo.remove(entity);
    }

    public void delete(long id) {
        delete(load(id));
    }

    public U load(long id) {
        U entity = repo.findBy(Long.valueOf(id));
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }



    /////////////////////////////////////////////////////////////////////////////////////////
    // METODOS DE SOPORTE A LA INTERFAZ DE USUARIO                                         //
    /////////////////////////////////////////////////////////////////////////////////////////

    public abstract Stream<U> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders);

    public abstract long countAnyMatching(Object padre, String filtro);

    protected String likePattern(String filter) {
        if(filter == null) filter = "";
        return "%" +filter + "%";
    }

    public  QueryResult<U> applySortOrder(QueryResult<U> result, List<QuerySortOrder> sortOrders) {
        QueryResult<U> queryResult = result;
        for (QuerySortOrder sortOrder : sortOrders) {
            if (sortOrder.getDirection() == SortDirection.ASCENDING) {
                queryResult = queryResult.orderAsc(sortOrder.getSorted());
            } else {
                queryResult = queryResult.orderDesc(sortOrder.getSorted());
            }
        }

        return queryResult;
    }
}
