package com.gmail.cacho.slapi.view.interfaces;

/**
 * Esta interface representa el comportamiento público generico deseable de una clase que
 * implementa un objeto visual manageable (que aquí quiere decir que es 'gestionable por
 * un manager' del sistema para operaciones que NO tienen un objeto Entidad asociado como
 * base para su funcionamiento. Admite operaciones CRUD (agregar, borrar, modificar, ver)
 * pero sin estar atado a una Entidad específica.
 * Cualquier objeto manageable debe poseer un objeto 'Manager' que será quien lo controle,
 * es decir que establezca su comportamiento en función de las acciones que el objeto vaya
 * a gestionar.
 *
 * @author larios
 * @version 20180201
 */
public interface IManageable extends ITabeable {
    /**
     * Este metodo debe ser encargado de retornar el objeto IPresenter del objeto presentable
     * en cuestión, es decir el objeto que lo controla en función de las acciones que el objeto
     * presentable puede generar.
     *
     * @return el presenter (controlador) del objeto presentable.
     */
    IManager getManager();

    /**
     * Este método debería retornar un objeto "mantenido" por el manageable y que debe
     * ser el cual se utiliza como base para "dirijir" un determinado CustomTab, el cual
     * a su vez debe pasar como parámtro su clase concreta para que el manageable sepa que
     * objeto debe devolver. Esto permite ue cada tab de un panel pueda conseguir el objeto
     * que pudiese necesitar para actualzarse, etc.
     *
     * @param claseTab la clase del Tab para el que se quiere el objeto.
     * @return El objeto del tipo correcto bajo gestión o null si no hay ninguno.
     */
    Object getObjetoMasterTab(Class claseTab);
}
