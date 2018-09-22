package com.gmail.cacho.slbase.persist.excepciones;


import com.gmail.cacho.slbase.core.Tools;
import com.gmail.cacho.slbase.core.excepciones.MessageException;

/**
 * Esta clase de excepcion deberia utilizarse para representar todos los errores asociados a un problema
 * con una transaccion de persistencia iniciada por la aplicacion, sea de bloqueo, acceso, o un problema
 * lanzado por el propio driver, asociada a transacciones, del motor de persistencia elegido.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class TransacErrorException extends MessageException {
    public TransacErrorException(String mensaje) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), "");
    }

    public TransacErrorException(String mensaje, String extra) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra);
    }
}