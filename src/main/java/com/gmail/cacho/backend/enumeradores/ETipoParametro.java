package com.gmail.cacho.backend.enumeradores;

/**
 * ETipoParametro es una enumeracion que contiene los distintas tipos de parametros que pueden existir
 * y persistir dentro de un sistema hecho par el framework. Esta enumeracion deberia ser utilizada dentro
 * de la clase parametro para establecer su tipo (por ejemplo: RECURSO, MENU, etc.).
 *
 * @author jmfragueiro
 * @version 20161011
 */
public enum ETipoParametro {
    NINGUNO,
    RECURSO,
    MENU,
    CONFIG,
    TIPOGESTION,
    FORMAPAGO,
    ESTADOCUENTA,
    ESTADOGESTION,
    RESULTADOGESTION,
    PROVINCIA,
    LOCALIDAD,
    TIPO_TITULO,
    TIPO_EDICION,
    TIPO_CARGO,
    TIPO_COMPROBANTE,
    ENTIDAD_BANCARIA
}
