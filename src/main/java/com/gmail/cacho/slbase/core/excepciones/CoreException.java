package com.gmail.cacho.slbase.core.excepciones;



import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.cacho.slbase.logging.LogService;

import java.io.Serializable;

/**
 * Esta clase de excepcion es la base de la jerarquia de excepciones del framework para las
 * excepciones que DEBE SER CAPTURADAS SI O SI dentro del sistema (son 'marcadas') y se usa
 * para encapsular el comportamiento general que debe tener una excepcion dentro del mismo.
 * <p>
 * La clase maneja da la posibilidad de crear una excepcion con un mensaje generico, con uno
 * especifico, o bien con uno especifico mas un texto extra aclaratorio. Ademas, esta clase
 * permite logear una excepcion, como un mensaje de nivel ERROR para el caso de que el nivel
 * de la aplicacion lo permita, utilizando para ello metodos estaticos de la clase LogSistema.
 *
 * @author jmfragueiro
 * @version 20161011
 * @see ENivelAplicacion
 * @see LogService
 */
public class CoreException extends Exception implements Serializable, Cloneable {
    protected String _mensaje;
    protected String _extra;
    protected ENivelAplicacion _nivel;

    /**
     * Esta version del contructor permite crear una excepcion sin mensaje ni datos extras
     * (utiliza en este caso un mensaje generico tomado de la constante MSJ_ERR_EXCEPCION).
     *
     * @see Constantes
     */
    public CoreException() {
        this(Constantes.MSJ_ERR_EXCEPCION, "", ENivelAplicacion.ERROR);
    }

    /**
     * Esta version del contructor permite crear una excepcion con mensaje y sin datos extras.
     *
     * @param mensaje El mensaje que describe la excepcion.
     */
    public CoreException(String mensaje) {
        this(mensaje, "", ENivelAplicacion.ERROR);
    }

    /**
     * Esta version del contructor permite crear una excepcion con mensaje y con datos extras.
     *
     * @param mensaje El mensaje que describe la excepcion.
     * @param extra   La cadena con datos extras para mostrar en la exepcion
     */
    public CoreException(String mensaje, String extra) {
        this(mensaje, extra, ENivelAplicacion.ERROR);
    }

    /**
     * Esta version del contructor permite crear una excepcion con mensaje, con datos extras
     * y estrableciendo el nivel del mensaje (para aquellos casos en que deba modificarse).
     *
     * @param mensaje El mensaje que describe la excepcion.
     * @param extra   La cadena con datos extras para mostrar en la exepcion
     * @param nivel   EL nivel de aplicacion que se quiere dar para esta excepcion
     * @see ENivelAplicacion
     */
    protected CoreException(String mensaje, String extra, ENivelAplicacion nivel) {
        super(mensaje);

        String username = Sistema.getSistema().getNombreUsuarioActivo();
        _mensaje = mensaje;
        _extra = extra;
        _nivel = nivel;

        LogService.getLog().logear(_nivel, Constantes.SYS_CAD_OPENTYPE + this.getClass().getSimpleName() + ((username != null)
                                                                                                            ? Constantes.SYS_CAD_REFER
                                                                                                                    .concat(username) : "")
                + Constantes.SYS_CAD_CLOSETPE + Constantes.SYS_CAD_LOGSEP + _mensaje, _extra);
    }

    /**
     * Este metodo retorna una version simplificada del mensaje asociado a la Excepecion.
     *
     * @return una cadena con una version simplificada del mensaje de la Excepcion.
     */
    public String getSimpleMenssage() {
        return _mensaje;
    }

    @Override
    public String toString() {
        return String.format("[%s]%s\r\n%s.", _nivel, _mensaje, _extra);
    }
}