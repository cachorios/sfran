package com.gmail.cacho.slapi.view.interfaces;

/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un controlador de un objeto visualizable del
 * sistema.
 *
 * @author larios
 * @version 20180201
 */
public interface IController {
    /**
     * Este método debe encargarse de aplicar los permisos que existan para el usuario
     * actual sobre "Recursos" (componentes de la vista) del objeto presentable en cuestión
     * (ver getTagVista() mas arriba).
     */
    void aplicarPermisos();
}
