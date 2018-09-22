package com.gmail.cacho.slapi.view.interfaces;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTab;

/**
 * Esta interface representa el comportamiento público generico deseable de una clase
 * que implementa un objeto visual presentable del sistema que puede ser incorporado
 * dentro de un grupo de tabs (CustomTabGroup).
 *
 * @author larios
 * @version 20180201
 */
public interface ISolapable<T extends AbstractEntidad> extends IVisualizableGestionable {
    /**
     * Un presentable tabeable tiene que registrar el tab al cual es agregardo,
     * ess decir el tab desde el cual se presenta. Este metodo deberia permitir
     * registrar dicho tab.
     *
     * @param tab el Tab establecido como padre, al que pertenecera el presente tableable.
     */
    void setTabPadre(CustomTab<T> tab);

    /**
     * Este metodo deberia retornar el tab al que se agrego el presentable para
     * que pueda comunicarse con el.
     *
     * @return el Tab al que pertenece el presente tabeable.
     */
    CustomTab<T> getTabPadre();

    /**
     * Este metodo debe servir para iniciar la actualizacion del contenido del solapable
     * a partir de algun tipo de evento generado por el padre del grupo de Tabs.
     *
     * @param parametro un objeto que podria servir para 'conducir' la actualización.
     */
    void actualizar(Object parametro);
}
