package com.gmail.cacho.slapi.view.interfaces;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

/**
 * Esta interface representa el comportamiento público generico deseable de una clase que
 * implementa un objeto visual que trabaja en modo "solo-lectura" (ReadOnly), de manera de
 * que todos los componentes que muestran datos se visualizan sin posibilidad de edición
 * alguna (disables, readonly, etc.) y todos los recursos de acción (como botones) deben
 * ser visibles y estar habilitados para trabajar.
 * Este tipo de objeto visual se piensa, por ejemplo, para ser utilizado para mostrar un
 * 'resumen' de los datos contenidos en los atributos de un Entidad o Proceso, como puede
 * ser un bloque de Preview.
 *
 * @author larios
 * @version 20180201
 */
public interface IVisualizableReadOnly<T extends AbstractEntidad> extends IVisualizable {

    /**
     * Este metodo debe crar los elementos especificos del objeto visualizable.
     */
    void crearElementos();

    /**
     * Este metodo debe actualizar lo mostrado por el visualizable, para lo cual podria
     * basarse en un objeto pasado como parametro (el cual se admite que pueda ser nulo
     * si no hiceiera falta).
     *
     * @param item un objeto que sirve para el proceso de actualización (o nulo si no hay).
     */
    void actualizar(T item);
}
