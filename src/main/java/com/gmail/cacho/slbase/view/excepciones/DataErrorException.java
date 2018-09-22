package com.gmail.cacho.slbase.view.excepciones;


import com.gmail.cacho.slbase.core.Tools;
import com.gmail.cacho.slbase.core.excepciones.MessageException;

/**
 * Esta clase de excepcion debe utilizarse para representar todos los errores asociados a un
 * problema con algun dato gestionado desde el sistema como algun dato especifico de una vista
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class DataErrorException extends MessageException {
    public DataErrorException(String mensaje) { super(Tools.getNombreMetodoLlamante(2).concat(mensaje), ""); }

    public DataErrorException(String mensaje, String extra) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra);
    }
}