package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTabGroup;

/**
 * Esta interface representa el comportamiento público generico deseable de una clase
 * que implementa un objeto del sistema que puede contener un grupo de tabs (TabGroup)
 * dentro de su estructura, y por lo tanto puede gestionarlo.
 *
 * @author larios
 * @version 20180201
 */
public interface ITabGroupContainer {
    /**
     * Este metodo debe retornar si el objeto presentable panel contiene
     * o no algún tab dentro de si.
     *
     * @return retorna 'true' si el panel contiene un tab, sino retorna 'false'
     */
    boolean contieneTabs();

    /**
     * Este método debe retornar la lista de tabs que puede tener el panel,
     * o bien nulo si es que el panel no tienen ninguna tab asociado.
     *
     * @return la lusta de tabs asociada al panel
     */
    CustomTabGroup getTabGroup();

    /**
     * Este método debería retornar un objeto del tipo que maneje el visuatable y que debe
     * ser el cual se utiliza como base para los tabs que podría contener el mismo. Dado que
     * un visuatable podría tener tabas basados en diferentes objetos, el método requiere como
     * argumento un tipo de Tab de manera de poder decidir que objeto entregar.
     *
     * @param claseTab la clase del Tab para el que se quiere el objeto.
     * @returns El objeto del tipo correcto bajo gestión o null si no hay ninguno.
     */
    AbstractEntidad getObjetoMasterTab(Class claseTab);

    /**
     * Este metodo debe encargarse de actualizar los tabs a partir de un nuevo objeto
     * que se debe tomar como padre para los mismos.
     *
     * @param item el nuevo objeto que debera tomarse como padre para los tabs
     */
    void actualizarTabs(Object item);
}
