package com.gmail.cacho.slbase.security.interfaces;



import java.util.Date;

/**
 * Esta interfase es la que representa el comportamiento deseable de una clase que implemente una entidad
 * persistente y que, a su vez, posea mecanismos de seguridad y auditoria especificos, los cuales puedan
 * determinar cierta trazabilidad de las modificaciones persistidas sobre la instancia auditada. Que es
 * especificamente lo que significa "traxabilidad de las modificaiciones" dependera de cada implementacion
 * basada en el framework. Asi, toda entidad que sea representada, persistida y auditada dentro del este
 * framework debe implementar esta interface.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public interface IEntidadAuditada<TKI>  {
    /**
     * Este metodo deberia ser capaz de devolver la cantidad de modificaciones persistidas hechas sobre una
     * instancia o bien deberia devolver nulo unicamente si la instancia en cuestion no ha sido aun persistida
     * (si isNew() retorna true). Si una instancia ha sido recientemente persistida se toma como primer cambio
     * a el seteo de su estado persistido incial, por lo que deberia devolver uno (1).
     *
     * @return Retorna la cantidad de modificaciones persitidas de la instancia o null si es una nueva.
     */
    int getVersion();

    /**
     * Este metodo deberia ser capaz de devolver la fecha en la que una instancia ha sido 'creada' y ha sido
     * efectivamente persistida o bien deberia devolver nulo unicamente si la instancia en cuestion no ha sido
     * persistida (si isNew() retorna true).
     *
     * @return Retorna la fecha de 'creacion' persitida de la instancia o null si es una nueva.
     */
    Date getFechaalta();

    /**
     * Este metodo deberia ser capaz de devolver el nombre del usuario que ha 'creado' (persistido) a una
     * instancia o deberia devolver nulo unicamente si la instancia en cuestion aun no ha sido persistida
     * (si isNew() retorna true).
     *
     * @return Retorna el usuario de 'creacion' persitida de la instancia o null si es una nueva.
     */
    String getUsuarioalta();

    /**
     * Este metodo deberia ser capaz de devolver la fecha en la que una instancia ha sido modificada por ultima
     * vez, y cuyas modificaciones han sido efectivamente persistidas o bien deberia devolver nulo unicamente si
     * la instancia en cuestion no ha sido persistida (si isNew() retorna true).
     *
     * @return Retorna la fecha de ultima modificacion persitida de la instancia o null si es una nueva.
     */
    Date getFechaumod();

    /**
     * Este metodo deberia ser capaz de devolver el nombre del usuario que ha persistido por ultima vez alguna
     * modificacion a una instancia o bien deberia devolver nulo unicamente si la instancia en cuestion aun no
     * ha sido persistida (si isNew() retorna true).
     *
     * @return Retorna el usuario de ultima modificacion persitida de la instancia o null si es una nueva.
     */
    String getUsuarioumod();
}
