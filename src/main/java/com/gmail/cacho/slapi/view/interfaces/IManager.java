package com.gmail.cacho.slapi.view.interfaces;

/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un 'controlador' (Manager) para un objeto
 * visuatable del sistema que NO sea definido específicamente sobre una
 * entidad del sistema (clase que extienda de la clase Entidad).
 *
 * @author larios
 * @version 20180201
 */
public interface IManager extends IController {
    /**
     * Este metodo debe ser encargado de establecer, para el presenter en cuestión,
     * cuál será su objeto presentable, es decir cuál será el objeto controlado por
     * este.
     *
     * @param presentable el objeto presentable controlado por el presenter.
     */
    void setGestionable(IVisualizableGestionable presentable);

    /**
     * Este metodo debe ser encargado de retornar el objeto presentable del presenter
     * en cuestión, es decir el objeto controlado por el mismo.
     *
     * @return el objeto presentable controlado por el presenter..
     */
    IVisualizableGestionable getGestionable();
}
