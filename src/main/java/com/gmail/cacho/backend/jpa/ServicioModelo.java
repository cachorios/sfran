package com.gmail.cacho.backend.jpa;



import com.vaadin.flow.data.provider.QuerySortOrder;

import com.vaadin.flow.data.provider.SortDirection;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.QueryResult;


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
public abstract class ServicioModelo<U>  {
    protected EntityRepository<U, ?> repo;

    protected EntityRepository<U, ?> getRepository(){
        return repo;
    }


    protected U save(U entidad){
        return repo.save(entidad);
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
