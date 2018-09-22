package com.gmail.cacho.slapi.view.excepciones;


import com.gmail.cacho.slbase.core.Tools;
import com.gmail.cacho.slbase.core.excepciones.MessageException;

/**
 * Esta clase de excepcion deberia utilizarse para representar todos los errores asociados a un problema
 * con una formateo de algun campo de una vista de la aplicacion.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class ViewFormatException extends MessageException {
	public ViewFormatException(String mensaje) {
		super(Tools.getNombreMetodoLlamante(2).concat(mensaje), "");
	}

	public ViewFormatException(String mensaje, String extra) {
		super(Tools.getNombreMetodoLlamante(2).concat(mensaje), extra);
	}
}
