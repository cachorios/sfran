package com.gmail.cacho.slbase.persist.excepciones;


import com.gmail.cacho.slbase.core.Tools;
import com.gmail.cacho.slbase.core.excepciones.CoreException;

/**
 * Esta clase de excepcion deberia utilizarse para representar todos los errores asociados a un problema
 * con el motor de persistencia del sistema, sea de conectividad, acceso, o un problema lanzado por el
 * el propio driver de dicho motor.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class PersistErrorException extends CoreException {
    public PersistErrorException(String mensaje) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), "");
    }

    public PersistErrorException(String mensaje, String extra) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra);
    }
}