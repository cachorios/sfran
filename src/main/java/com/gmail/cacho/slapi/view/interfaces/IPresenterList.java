package com.gmail.cacho.slapi.view.interfaces;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;


import java.util.List;

/**
 * Esta interface representa el comportamiento deseable de una
 * clase que establezca una vista tipo listado para un tipo
 * determinado de entidad del sistema.
 *
 * @param <T> La entidad para la cual funciona el listado.
 */
public interface IPresenterList<T extends AbstractEntidad> extends IPresenter<T> {
    /**
     * Este método permite obtener el dataprovider del listado.
     *
     * @return el dataprovider para el listado
     */
    FilterablePageableDataProvider<T, Long, String> getDataProvider();

    /**
     * Este metodo es el encargado de setear, en caso de existir, el item
     * padre del listado controlado por la presente instancia del Presenter.
     * El item padre actua como un filtro de base sobre el listado resultado
     * y que se aplica independientemente del filtro que se cargue en el
     * listado.
     *
     * @param item el item padre para el listado
     */
    void setItemPadre(Object item);

    /**
     * Este metodo es el encargado de retornar el item padre actual del listado.
     *
     * @return el item padre actual del listado o null si no hay seteado.
     */
    Object getItemPadre();

    /**
     * Este método retorna la cantidad de registros contenidos en el objeto
     * dataprovider del listado y basado en ultima búsqueda -listList- que
     * se haya realizado sobre la vista.
     */
    long getCantidadRegActual();

    /**
     * Este método retorna la cantidad total de registros asociados a la entidad
     * contenida en el objeto dataprovider del listado.
     */
    long getCantidadRegTotal();

    /**
     * Este método es el encargado de manejar el cambio en la selección
     * de las filas dentro del listado (por ejemplo: puede ser llamado
     * por un panel de listado al cambiar la selección dentro del mismo).
     * NOTA: la grilla de un listado NO debería permitir la deselección
     * de filas.
     *
     * @param seleccion La colección de filas seleccionadas en el listado.
     */
    void alActualizarSeleccion(List<T> seleccion);

    /**
     * Este método es el encargado de gestionar la acción de "Relistar" el
     * listado. Debe trabajar sobre el tipo de objeto del tipo de la entidad
     * en cuestión, dependiendo de sus métodos (y lanzando sus excepciones).
     *
     * @param parametro un Parametro que pudiese necesitarse para armar el listado.
     */
    void listList(Object parametro);

    /**
     * Este método es el encargado de gestionar la acción de Ver
     * un elemento desde el listado. Debe trabajar sobre el tipo
     * de objeto del tipo de la entidad en cuestión, dependiendo
     * de sus métodos (y lanzando sus excepciones).
     */
    void listView();

    /**
     * Este método es el encargado de gestionar la acción de Agregar
     * un elemento desde el listado. Debe trabajar sobre el tipo
     * de objeto del tipo de la entidad en cuestión, dependiendo
     * de sus métodos (y lanzando sus excepciones).
     */
    void listAdd();

    /**
     * Este método es el encargado de gestionar la acción de Editar
     * un elemento desde el listado. Debe trabajar sobre el tipo
     * de objeto del tipo de la entidad en cuestión, dependiendo
     * de sus métodos (y lanzando sus excepciones).
     */
    void listEdit();

    /**
     * Este método es el encargado de gestionar la acción de Borrar
     * un elemento desde el listado. Debe trabajar sobre el tipo
     * de objeto del tipo de la entidad en cuestión, dependiendo
     * de sus métodos (y lanzando sus excepciones).
     */
    void listRemove();
}
