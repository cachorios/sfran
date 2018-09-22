package com.gmail.cacho.slbase.core.enums;

/**
 * ENivelAplicacion es una enumeracion que contiene los distintas niveles de mensajes y de ejecucion de
 * la aplicación o que pueden existir y utilizarse dentro de este. Por ejemplo se puede usar el nivel de
 * ejecucion para contrastar con el de un mensaje para decidir si se debe logear o no el mismo (entre
 * otras cosas que pudiesen surgir durante el procesamiento).
 *
 * @author jmfragueiro
 * @version 20161011
 */
public enum ENivelAplicacion {
    NINGUNO,
    BATCH,
    DEBUG,
    INFO,
    WARNING,
    NORMAL,
    ERROR,
    FATAL,
    SISTEMA
}
