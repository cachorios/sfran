package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;

/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un objeto visual presentable (que aquí quiere
 * decir 'gestionable por un presenter' del sistema ya sea para listas, para
 * forms de edición CRUD (agregar, borrar, modificar, ver) o cualquier otro
 * tipo definido para trabajar sobre una entidad del sistema (clase Entidad).
 * Cualquier objeto presentable debe poseer un objeto 'Presenter' que será
 * quien lo controle, es decir que establezca su comportamiento en función
 * de las acciones que el objeto presentable pueda gestionar.
 *
 * @author larios
 * @version 20180201
 */
public interface IPresentable<T extends AbstractEntidad> extends ITabeable {
    /**
     * Este metodo retorna la clase del tipo de ENTIDAD que "comanda" (o al que se
     * refiere) el objeto presentable en cuestion. Obviamente en este caso se trata
     * de una clase que extiende Entidad.
     *
     * @return la clase del tipo de Entidad que es la principal que alberga la vista
     */
    Class<T> getEntityType();

    /**
     * Este metodo debe ser encargado de retornar el objeto IPresenter del objeto presentable
     * en cuestión, es decir el objeto que lo controla en función de las acciones que el objeto
     * presentable puede generar.
     *
     * @return el presenter (controlador) del objeto presentable.
     */
    IPresenter<T> getPresenter();

    /**
     * Este método debería establecer un objeto del tipo que maneja el presentable y que debe
     * ser el cual se encuentra bajo gestión al momento de la llamada (por ejemplo: el objeto
     * obtenido a partir de la fila de datos seleccionada en un listado o el objeto bajo edicion
     * en un formulario tipo CRUD).
     *
     * @param objeto El objeto del tipo correcto para gestionar en el presentable.
     */
    void setObjetoActivo(T objeto);

    /**
     * Este método debería retornar un objeto del tipo que maneja el presentable y que debe
     * ser el cual se encuentra bajo gestión al momento de la llamada (por ejemplo: el objeto
     * obtenido a partir de la fila de datos seleccionada en un listado o el objeto bajo edicion
     * en un formulario tipo CRUD).
     *
     * @returns El objeto del tipo correcto bajo gestión o null si no hay ninguno.
     */
    T getObjetoActivo();

    /**
     * Este metodo debe permitir establecer el estado inicial de un objeto presentable, de
     * manera mas o menos independiente de los datos que pudiese recibir al iniciarse.
     */
    void establecerEstadoInicial();

    /**
     * Este metodo debe permitir establecer si un determinado Componente Visual del objeto
     * presentable, que ha sido registrado, puede ser visualizado.
     */
    boolean esVisualizable(ComponenteVista componente);

    /**
     * Este metodo debe permitir establecer si un determinado Componente Visual del objeto
     * presentable, que ha sido registrado, puede ser habilitado para interaccionar con el
     * usuario.
     */
    boolean esHabilitable(ComponenteVista componente);
}
