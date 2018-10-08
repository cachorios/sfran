package com.gmail.cacho.slapi.comunes;

/**
 * Esta case debe contener la definición de todos los TAG de "Recursos" (componentes) de vista
 * del sistema. Se supone que por cada cadena aquí definida existe un Componente de vista (un
 * botón o algo similar) y un registro en la tabla Parametros que lo represente como recurso del
 * sistema.
 * <p>
 * Toda vista debe tener un TAG de Recurso de Vista, el cual servirá para identificar,
 * por ejemplo, los botones de acción que posea y de esta manera definir cuáles activar
 * en función de los permisos del usuario sobre dichos recursos.
 * <p>
 * Cada "recurso" de una vista que se quiera identificar dentro del sistema tendrá un TAG
 * formado por el TAG (un String) de la Vista y el TAG (tambien String) del componente en
 * cuestion representado por el recurso. El TAG del componente debe ser ingresado, en la
 * creación del mismo, en el atributo "Data" de dicho componente (con setData(...)).
 * Luego, debe existir un "parametro" (objeto de Tipo parametro y por ello un registro en
 * la tabla Parametros) que tenga en su atributo "nombre" (obtenido vía getNombre()) el
 * String resultado formado por "TAG-VISTA"."TAG-COMPONENTE".
 * A partir del Recurso (parametro) y de un tipo de permiso (ETipoPermiso), se podrá crear
 * un objeto Permiso que podrá ser asignado a un Rol determinado.
 * Para mostrar un componente, es preciso entonces que el Usuario actual tenga un Rol que
 * tenga permisos sobre dicho Recurso.
 * <p>
 * NOTA: obviamente cada TAG (para cada tipo de vista) debería ser único!!!
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class Recursos {
    public static final String RCV_CLASE_IMAGE_DIR = "/frontend/images/";
    public static final String RCV_CLASE_PARAM = "RECURSO_VISTA";
    public static final String RCV_TAG_SPARATOR = ".";

    /**********************************************************
     * RECURSOS DE: botones generales del sistema
     **********************************************************/
    public static final String RCV_BTN_ALLCAN = "*";
    public static final String RCV_BTN_VER = "RCV_BTN_VER";
    public static final String RCV_BTN_NUEVO = "RCV_BTN_NUEVO";
    public static final String RCV_BTN_EDITAR = "RCV_BTN_EDITAR";
    public static final String RCV_BTN_BORRAR = "RCV_BTN_BORRAR";
    public static final String RCV_BTN_CONFIG = "RCV_BTN_CONFIG";
    public static final String RCV_BTN_SELECT = "RCV_BTN_SELECT";

    /**********************************************************
     * RECURSOS DE: Vistas de Entidad PARAMETRO
     **********************************************************/
    public static final String RCV_TITULO_LIST_PARAM = "PARAMETROS";
    public static final String RCV_TITULO_FORM_PARAM = "PARAMETRO";
    public static final String RCV_TAG_PARAM = "RCV_TAG_PARAM";

    /**********************************************************
     * RECURSOS DE: Vistas de Entidad USUARIO
     **********************************************************/
    public static final String RCV_TITULO_LIST_USUARIO = "USUARIOS";
    public static final String RCV_TITULO_FORM_USUARIO = "USUARIO";
    public static final String RCV_TAG_ROL = "RCV_TAG_ROL";

    /**********************************************************
     * RECURSOS DE: Vistas de Entidad ROL
     **********************************************************/
    public static final String RCV_TITULO_LIST_ROL = "ROLES";
    public static final String RCV_TITULO_FORM_ROL = "ROL";
    public static final String RCV_TAG_USUARIO = "RCV_TAG_USUARIO";
}
