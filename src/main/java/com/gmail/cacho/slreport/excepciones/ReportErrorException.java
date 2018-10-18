package com.gmail.cacho.slreport.excepciones;

import com.gmail.cacho.slbase.core.Tools;
import com.gmail.cacho.slbase.core.excepciones.MessageException;

/**
 * Esta clase de excepcion debe utilizarse para representar todos los errores asociados
 * a un problema con alguna ventana o algun componente del esquema de reportes del sistema.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class ReportErrorException extends MessageException {
    public ReportErrorException(String mensaje) { super(Tools.getNombreMetodoLlamante(2).concat(mensaje), ""); }

    public ReportErrorException(String mensaje, String extra) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra);
    }
}