package com.gmail.cacho.slbase.core;

/**
 * Esta case debe ser utilizada como un punto focal para todas los metodos genericos de herramienta dentro
 * del framework, de manera de tener encasulada, en una sola clase, todas las cuestiones asociadas a este
 * tipo de necesidades.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public abstract class Tools {
    /**
     * Este metodo retorna el lugar exacto desde donde es llamado como una cadena presentada como:
     * [CLASE:METODO:NroLinea]. Hay que tener en cuenta que el número de linea puede estar asociado
     * (en una llamada desde una excepcion) a la línea desde donde se gestiona la exepcion (catch).
     *
     * @param index, el indice de metodo llamante requerido.
     * @return Retorna el lugar exacto desde donde es llamado.
     */
    public static String getNombreMetodoLlamante(int index) {
        StackTraceElement ste = new Exception().getStackTrace()[index];
        return Constantes.SYS_CAD_OPENTYPE.concat(ste.getClassName()).concat(Constantes.SYS_CAD_LOGSEP).concat(ste.getMethodName())
                                          .concat(Constantes.SYS_CAD_LOGSEP).concat(String.valueOf(ste.getLineNumber()))
                                          .concat(Constantes.SYS_CAD_CLOSETPE);
    }
}
