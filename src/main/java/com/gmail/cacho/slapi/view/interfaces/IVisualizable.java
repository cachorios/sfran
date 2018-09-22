package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.vaadin.flow.component.Component;

/**
 * Esta interface representa el comportamiento público base generico deseable
 * de una clase que implementa un objeto visual para trabajar en el sistema.
 * Inicialmente no se le pide nada específico sino que debe funcionar como
 * base de la jerarquia.
 *
 * @author larios
 * @version 20180201
 */
public interface IVisualizable {
    /**
     * Este metodo debe ser el punto de entrada al armado inicial de la visualización
     * del objeto presentable, y se espera que en el se recorran todos los pasos que
     * sean necesarios para que la vista se encuentre "lista" para ser mostrada. Aqui,
     * además del modo de visualización (VER, NUEVO, EDITAR, BORRAR, etc.), podría ser
     * pasado un objeto que sera utilizado para trabajarlo dentro de la vista, como un
     * objeto 'master' que filtre la lista mostrada (en los casos de List) o el objeto
     * que estara bajo edición (en los casos de un Form).
     *
     * @param modo El modo de visualización en el que se debe iniciar.
     * @param item Un item a ser tomado para trabajarlo en la vista (puede ser nulo).
     */
    void iniciar(EModoVista modo, AbstractEntidad item);

    /**
     * Este metodo debe retornar el modo en que se visualiza actualmente al objeto
     * visualizable (según la enumeración EMOdoVista: VER, NUEVO, EDITAR, BORRAR),
     * lo que define, por ejemplo, qué botones serán mostrados, entre otras cosas.
     *
     * @return el modo de visualización actual del objeto visualizable.
     */
    EModoVista getModoVista();

    /**
     * Este metodo debe retornar el elemento visual específico que representa al objeto
     * visible actual. Si bien en este caso se utiliza como tipo de retorno a Component
     * de Vaadin, en un futuro podría cambiarse por otro tipo en funcion del framework
     * de componentes visuales utilizado.
     *
     * @return el Componente visual que representa al objeto visible actual.
     */
    Component getViewComponent();

    /**
     * Este metodo es el que le dice a una vista que el usuario ha determinado que la
     * misma debe cerrarse, para lo cual deberian ejecutarse todos los procesos que se
     * consideren necesarios a tal fin.
     */
    void cerrar();

    /**
     * Este metodo debe retornar el padre de un objeto visualizable, el cual sería
     * el objeto que lo genera y administra. Si un objeto determinado retorna nulo,
     * significa que no tiene padre y es, por tanto, el primero objeto visualizable
     * lanzado por el Sistema (por ejemplo el objeto visual que se muestra primero
     * al seleccionar una opción del menú principal).
     *
     * @return el objeto visualizable padre del actual o nulo si no lo tiene.
     */
    IVisualizable getPadre();

    /**
     * Este metodo debe establecer el padre de un objeto visible, el cual sería el
     * objeto que lo genera y administra. Si un objeto determinado no tiene padre
     * significa que es, por lo tanto, un primer objeto visualizable lanzado por el
     * Sistema (por ejemplo el objeto visual que se muestra primero al seleccionar
     * una opción del menú principal).
     *
     * @param padre el objeto visualizable padre del actual o nulo si no lo tiene.
     */
    void setPadre(IVisualizable padre);
}
