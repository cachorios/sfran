package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.slapi.view.customs.tabs.CustomTab;

/**
 * Esta interface representa el comportamiento público generico deseable de una clase
 * que implementa un objeto visual del sistema que puede ser incorporado dentro de un
 * grupo de tabs (CustomTabGroup) como un tab (solapa) mas del grupo.
 *
 * @author larios
 * @version 20180201
 */
public interface ITabeable extends IVisualizableGestionable {
    /**
     * Un objeto tabeable tiene que registrar el tab al cual es agregado y que
     * lo controlará, es decir el tab desde el cual se presenta y gestiona. Este
     * metodo deberia permitir registrar dicho tab.
     *
     * @param tab el Tab establecido como padre, al que pertenecera el presente tabeable.
     */
    void setTabpadre(CustomTab tab);

    /**
     * Este metodo deberia retornar el tab al que se agrego el presente tabeable
     * para que pueda comunicarse con el.
     *
     * @return el Tab al que pertenece el presente tabeable.
     */
    CustomTab getTabpadre();

    /**
     * Un objeto tabeable tiene que poder mostrarse u ocultarse en función de las
     * necesidades, por ejemplo impuestas por el tab que lo controla (tab padre).
     *
     * @param visible un valor boleano que indica si el objeto debe visualizarse o no.
     */
    void setVisible(boolean visible);

    /**
     * Este metodo deberia retornar el tab al que se agrego el presentable para
     * que pueda comunicarse con el.
     *
     * @return un valor boleano que indica si el objeto es visible o no.
     */
    boolean isVisible();

    /**
     * Este metodo debe servir para iniciar la actualizacion del contenido del objeto
     * visualizable a partir de algun tipo de evento generado por el sistema. Ademas,
     * la actualización podría depender de algún tipo de objeto que la "dirija".
     *
     * @param parametro un objeto que podria servir para 'conducir' la actualización (o nulo si no hay).
     */
    void actualizar(Object parametro);
}
