package com.gmail.cacho.slbase.core.excepciones;


import com.gmail.cacho.slbase.core.Tools;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;

/**
 * Esta clase de excepcion debe utilizarse para representar todos los errores asociados a un
 * problema de con la aplicacion misma que resulten en un error fatal para el sistema, o sea
 * que se deberia terminar la aplicacion y salir a raiz del problema origen de la excepcion.
 * Esta clase modifica el nivel de aplicacion asignado a la excepcion transformandolo en FATAL,
 * de manera de asegurar el logeo de dicha situacion.
 *
 * @author jmfragueiro
 * @version 20161011
 * @see ENivelAplicacion
 */
public class FatalErrorException extends CoreException {
    public FatalErrorException(String mensaje) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), "", ENivelAplicacion.FATAL);
    }

    public FatalErrorException(String mensaje, String extra) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra, ENivelAplicacion.FATAL);
    }

    public FatalErrorException(String mensaje, String extra, ENivelAplicacion nivel) {
        super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra, nivel);
    }
}