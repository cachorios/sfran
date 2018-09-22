package com.gmail.cacho.slbase.view.excepciones;


import com.gmail.cacho.slbase.core.Tools;
import com.gmail.cacho.slbase.core.excepciones.MessageException;

/**
 * Esta clase de excepcion debe utilizarse para representar todos los errores asociados
 * a un problema con alguna ventana o algun componente grafico o visual del sistema.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class VistaErrorException extends MessageException {
    public VistaErrorException(String mensaje) { super(Tools.getNombreMetodoLlamante(2).concat(mensaje), ""); }

    public VistaErrorException(String mensaje, String extra) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra);
    }
}