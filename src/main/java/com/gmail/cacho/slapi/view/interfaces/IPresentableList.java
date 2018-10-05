package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.view.utils.ColumnList;

import java.util.List;

/**
 * Esta interfase representa el comportamiento público generico deseable de una clase
 * que implementa un objeto visual presentable del sistema ya sea para listas, para
 * forms de edición CRUD (agregar, borrar, modificar, ver), para un preview, y/o para
 * cualquier otro tipo definido para trabajar sobre una entidad del sistema (Entidad).
 * Cualquier objeto presentable debe poseer un objeto 'Presenter' que será quien lo
 * controle, es decir que establezca su comportamiento en función de las acciones que
 * el objeto presentable pueda gestionar.
 *
 * @author larios
 * @version 20180201
 */
public interface IPresentableList<T extends AbstractEntidad> extends IPresentable<T> {
    /**
     * Una lista tiene que permitir la posibilidad de tener un formulario CRUD
     * asociado, el cual será utilizado para las operaciones de VER, EDITAR, y
     * NUEVO. Este metodo es el encargado de establecer dicho formulario CRUD
     * asociado.
     *
     * @param form el formulario CRUD a asociar al presente listado.
     */
    void setForm(IPresentableForm<T> form);

    /**
     * Una lista tiene que permitir la posibilidad de tener un formulario CRUD
     * asociado, el cual será utilizado para las operaciones de VER, EDITAR, y
     * NUEVO. Este metodo es el encargado de retornar el formulario que ha sido
     * establecido como fomulario asociado.
     *
     * @return el formulario CRUD asociado al presente listado.
     */
    IPresentableForm<T> getForm();

    /**
     * Una lista tiene que permitir la posibilidad de tener un formulario de
     * preview asociado, el cual será utilizado para ver un resumen de los datos
     * del elemento asociado a la fila en foco dentro del listado. Este metodo es
     * el encargado de retornar el fomurlario de preview que ha sido establecido
     * como fomulario preview asociado.
     *
     * @return el formulario de preview asociado al presente listado.
     */
    IVisualizableReadOnly<T> getPreview();

    /**
     * Una lista tiene que permitir la posibilidad de tener un formulario de
     * preview asociado, el cual será utilizado para ver un resumen de los datos
     * del elemento asociado a la fila en foco dentro del listado. Este metodo
     * es el encargado de establecer dicho fomulario de preview asociado.
     *
     * @param preview el formulario de preview a asociar al presente listado.
     */
    void setPreview(IVisualizableReadOnly<T> preview);

    /**
     * Toda clase presentable de tipo Lista debe contener una lista de columnas a
     * mostrar. Este metodo debe retornar dicha lista de columnas.
     *
     * @return La lista de columnas del List presentable
     */
    List<ColumnList> getListaCols();

    /**
     * Este metodo debe encargarse de refrescar la lista contenida en el presentable.
     *
     * @param parametro un parametro que permita adaptar el refresco a las condiciones actuales.
     */
    void refrescarLista(Object parametro);
}
