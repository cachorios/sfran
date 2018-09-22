package com.gmail.cacho.slbase.security.enums;

/**
 * Enumeracion que contiene los distintos tipos de permisos de acceso a un recurso de la aplicacion.
 * El tipo de un permiso es un valor que permite establecer los distintos niveles de acceso y trabajo
 * con los recursos de la aplicacion.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public enum ETipoPermiso {
    NINGUNO,
    VER,
    AGREGAR,
    EDITAR,
    REMOVER,
    EJECUTAR,
    TOTAL
}
