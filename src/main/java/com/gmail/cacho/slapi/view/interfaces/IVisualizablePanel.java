package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.backend.entidad.AbstractEntidad;

/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un objeto visual presentable del sistema que
 * es un panel de trabajo general.
 * Un panel de trabajo se utiliza para llevar adelante procesos generales de
 * tipo especifico y no necesariamente deberían tener un objeto principal,
 * aunque el metodo 'iniciar(EmodoVista, item)' puede pasar dicho objeto,
 * de manera que el mismo se inicie con un objeto base para trabajar, pero no
 * se deberia controlar la modificación del estado de dicho objeto (para eso
 * habria que usar un IPresentableForm).
 *
 * @author larios
 * @version 20180201
 */
public interface IVisualizablePanel extends IVisualizableGestionable, ITabGroupContainer, ISolapable {
    /**
     * Este metodo debe permitir establecer el 'estado de habilitación' del panel
     * presentable, es decir si se permite la edicion dentro de sus campos o si solo se
     * permite la visualización.
     *
     * @param enable el valor que establece si se permite la edición (true) ó no (false)
     */
    void setEditableState(boolean enable);

    /**
     * Este metodo debe permitir establecer un codigo que deberá ser ejecutado para el caso
     * de que el Formulario realice una operación de persistencia de cambios que finaliza
     * de manera correcta.
     *
     * @param runnable un ejecutable para cuando el panel termina bien una operacion de persistencia
     */
    void setExecutableOnSaveOK(Runnable runnable);

    /**
     * Este metodo debe permitir obtener el codigo que deberá ser ejecutado para el caso
     * de que el Formulario realice una operación de persistencia de cambios que finaliza
     * de manera correcta.
     *
     * @return un ejecutablea ejecutar si el panel termina bien una operacion de persistencia
     */
    Runnable getExecutableOnSaveOK();

    /**
     * Este metodo debe ser encargado de retornar el objeto IManager del objeto visuatable
     * en cuestión, es decir el objeto que lo controla en función de las acciones que el objeto
     * visuatable puede generar.
     *
     * @return el presenter (controlador) del objeto visuatable.
     */
    IManager getManager();

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
}
