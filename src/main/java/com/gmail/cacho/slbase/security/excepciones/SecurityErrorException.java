package com.gmail.cacho.slbase.security.excepciones;


import com.gmail.cacho.slbase.core.Tools;
import com.gmail.cacho.slbase.core.excepciones.CoreException;

/**
 * Esta clase de excepción debe utilizarse para representar todos los errores asociados a
 * un problema de acceso, o permiso a un recurso o de ejecucion de una accion determinada.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class SecurityErrorException extends CoreException {
    public SecurityErrorException(String mensaje) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), "");
    }

    public SecurityErrorException(String mensaje, String extra) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra);
    }
}