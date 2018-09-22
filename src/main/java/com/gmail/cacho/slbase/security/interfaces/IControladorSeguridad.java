package com.gmail.cacho.slbase.security.interfaces;


import com.gmail.cacho.backend.entidad.Usuario;

/**
 * Esta interfase es la que representa el comportamiento deseable de una clase que implemente y controle
 * el servicio de seguridad de una aplicacion completa, el cual debe encargarse, para ello, de brindar
 * funciones de gestion de usuario, roles, permisos y manejo de sesiones. Tambien se incluye verificacion
 * de permisos de acceso a recursos especificos.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public interface IControladorSeguridad {
    /**
     * Este metodo debe permitir establecer si el usuario actualmente activo en el sistema se encuentra logeado
     *
     * @return reotrna "true" si el usuario activo se encuentra logeado o, si no, "false"
     */
    boolean isUserSignedIn();

    /**
     * Este metodo debe permitir obtener el usuario actualmente activo y logeado dentro del sistema
     *
     * @return el usuario actualmente activo y logeado dentro del sistema
     */
    Usuario getUsuarioActivo();

    /**
     * Este metodo debe retorna el nombre 'visible' del usuario activo en el Servicio de Seguridad
     * del sistema, o bien null si no hay ninguno.
     *
     * @return Retorna una cadena con el nombre 'visible' del usuario activo en el sistema.
     */
    String getNombreDeUsuarioActivo();

    /**
     * Este metodo debe retorna si el usuario actualmente logeado posee un permiso a partir de una
     * cadena que representa al toString() del permiso.
     *
     * @return Retorna 'true' si el usuario posee el permiso o 'false' si no lo posee.
     */
    boolean usuarioActivoPoseeCadenaPermiso(String permiso);

    /**
     * Este metodo debe deslogear a un usuario del sistema.
     */
    void logoff();
}