package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.backend.entidad.AbstractEntidad;

public interface IPresenterForm<T extends AbstractEntidad> extends IPresenter<T> {
    /**
     * Este metodo deberia ser llamado por el objeto presentable al momento de crear un
     * nuevo item (cuando se abre el panel en modo AGREGAR) y debera ser el encargado de
     * establecer cualqueir atributo que sea necesario sobre el objeto a crearse.
     *
     * @param itemToAdd el nuevo objeto que debe ser preseteado
     */
    void presetOnAdd(T itemToAdd);

    /**
     * Este metodo debería ser llamado justo antes de guardar cualqueir modificacion para
     * que se controle aqui cualuier cuestion asociada al modelos de negocio del elemento
     * a ser guardado. Si hubiere error no deberia salir con excepción, sino mostrar en
     * pantalla cualquier error encontrado y volver con false.
     *
     * @return debe retornar true si esta ok y puede continuar el guadardo o false si no
     */
    boolean isModelOKForSave();

    /**
     * Este método es el encargado de gestionar la acción de guardar las modificaciones
     * sobre un elemento (esto puede ser, por ejem, al motor de persistencia) que pueda
     * ser activada de la interfaz pertinente. Debe trabajar sobre el objeto en edición.
     */
    void formSave();

    /**
     * Este método es el encargado de gestionar la acción de guardar las modificaciones
     * sobre un elemento (esto puede ser, por ejem, al motor de persistencia) seguida de
     * la acción de volver a inicializar el formulario presentable para que así se pueda
     * agregar un nuevo elemento desde el panel.
     */
    void formSaveAndAdd();

    /**
     * Este método es el encargado de gestionar la acción de guardar las modificaciones
     * sobre un elemento (esto puede ser, por ejem, al motor de persistencia) que pueda
     * ser activada de la interfaz pertinente pero para cuando el propio formulario debe
     * continuar funcional, como si fuese un guardado que permite continuar la edicion.
     * Esto normalmente se usa cuando un list pide el guardado para abrir un subform.
     * Debe trabajar sobre el objeto en edición.
     *
     * @param onOK un ejecutable para lanzar si la grabacion termina OK
     */
    void formSaveAndContinue(Runnable onOK);

    /**
     * Este método es el encargado de gestionar la acción de cerrar el formulario. Aqui
     * se espera que se controle si hay cambios sin guardar, entre otras consideraciones.
     */
    void formClose();
}
