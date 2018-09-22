package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.backend.entidad.AbstractEntidad;

/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un 'controlador' (Presenter) de un objeto
 * visual presentable del sistema definido sobre una entidad del sistema
 * (clase Entidad).
 *
 * @author larios
 * @version 20180201
 */
public interface IPresenter<T extends AbstractEntidad> extends IController {
    /**
     * Este metodo debe ser encargado de establecer, para el presenter en cuestión,
     * cuál será su objeto presentable, es decir cuál será el objeto controlado por
     * este.
     *
     * @param presentable el objeto presentable controlado por el presenter.
     */
    void setPresentable(IPresentable<T> presentable);

    /**
     * Este metodo debe ser encargado de retornar el objeto presentable del presenter
     * en cuestión, es decir el objeto controlado por el mismo.
     *
     * @return el objeto presentable controlado por el presenter.
     */
    IPresentable<T> getPresentable();
}
