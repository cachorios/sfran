package com.gmail.cacho.slbase.persist.excepciones;


import com.gmail.cacho.slbase.core.Tools;
import com.gmail.cacho.slbase.core.excepciones.MessageException;

/**
 * Esta clase de excepcion deberia utilizarse para representar todos los errores asociados a un problema
 * con alguna de las propiedades basicas de una entidad dentro del framework, los que puede asociarse a
 * operaciones propias de la entidad y mas alla de cualquier otro contexto interviniente.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class EntityErrorException extends MessageException {
    public EntityErrorException(String mensaje) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), "");
    }

    public EntityErrorException(String mensaje, String extra) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra);
    }
}
