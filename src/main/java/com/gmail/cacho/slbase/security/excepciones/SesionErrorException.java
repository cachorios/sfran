package com.gmail.cacho.slbase.security.excepciones;


import com.gmail.cacho.slbase.core.Tools;
import com.gmail.cacho.slbase.core.excepciones.CoreException;

/**
 * Esta clase de excepción debe utilizarse para representar todos los errores asociados a un
 * problema con la sesion de usuario dentro del sistema (inicio, finalizacion, acceso, etc.).
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class SesionErrorException extends CoreException {
    public SesionErrorException(String mensaje) { super(Tools.getNombreMetodoLlamante(2).concat(mensaje), ""); }

    public SesionErrorException(String mensaje, String extra) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra);
    }
}