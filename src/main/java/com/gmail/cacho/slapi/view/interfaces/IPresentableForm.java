package com.gmail.cacho.slapi.view.interfaces;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.vaadin.flow.data.binder.BeanValidationBinder;

/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un objeto visual presentable del sistema que
 * es un formulario CRUD (que permite agregar, borrar, modificar y ver),
 * para objetos de una determinada entidad del sistema (clase Entidad).
 * Un formulario CRUD se utiliza para trabajar contra un objeto Entidad de
 * tipo especifico y este objeto debe setearse principalmente a traves del
 * metodo 'iniciar(EmodoVista, item)' que pase dicho objeto al formulario,
 * de manera que el mismo siempre inicie con un objeto para trabajar. Esto
 * implica que incluso si se tratara de la creación de un nuevo objeto (opción
 * EmodoVista.NUEVO), igual el llamante deberia crear una instancia vacía y
 * pasarsela al formulario para que allí se complete y, eventualmente, guarde.
 *
 * @author larios
 * @version 20180201
 */
public interface IPresentableForm<T extends AbstractEntidad> extends IVisualizableGestionable, IPresentable<T>, ITabGroupContainer {
    /**
     * Este metodo debe permitir obtener el binder en uso asociado al formulario.
     *
     * @return el binder asociado al formulario.
     */
    BeanValidationBinder<T> getBinder();

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
