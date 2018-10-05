package com.gmail.cacho.slapi.view.interfaces;


/**
 * Esta interface representa el comportamiento público generico deseable de una clase que
 * implementa un objeto visual manageable del sistema que es un panel, que puede admitir
 * opeaciones CRUD (agregar, borrar, modificar y ver), pero que no tiene a un objeto o una
 * Entidad específica que comande todas las funciones del mismo, sino que es "agnóstico",
 * por decirlo de alguna manera, repecto de las Entidades (podría no trabajar cobre ninguna
 * o bien trabajar sobre muchas). En caso de que hubiese algún tipo de objeto asociado, o
 * una lista de objetos, puede setearse a traves del metodo 'iniciar(EmodoVista, item)',
 * de manera que el mismo inicie con dicho objeto para trabajar.
 *
 * @author larios
 * @version 20180201
 */
public interface IManageablePanel extends IManageable, ITabGroupContainer {
    /**
     * Este metodo debe decirnos si el formulario presenta cambios sobre el objeto
     * activo (bajo edicion) que aún no han sido persistidos.
     *
     * @return 'true' si hay cambios si persistir, de lo contrario 'false'
     */
    boolean hasUnsavedChanges();

    /**
     * Este metodo debe decirnos si el formulario presenta errores en los datos
     * ingresados.
     *
     * @return 'true' si hay cambios si persistir, de lo contrario 'false'
     */
    boolean hasValidationErrors();

    /**
     * Este metodo debe permitir establecer el 'estado de habilitación' del formulario
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
}
