package com.gmail.cacho.slbase.core;

/**
 * Esta case debe ser utilizada como un punto focal para todos los manejos de textos dentro del framework},
 * de manera de tener encasulada, en una sola clase, todas las cuestiones asociadas a este tipo de valores.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public abstract class Constantes {
    /******************************************************************************************
     ** VALORES GLOBAL DE CONFIGURACION DEL SISTEMA
     ******************************************************************************************/
    public static final int SYS_TEXTCHANGEDELAY = 900;

    /******************************************************************************************
     ** CADENAS PROPIAS DEL SISTEMA A REALIZARSE
     ** NOTA: estas variables deben setearse para cada sistema en "resources/sistema.properties"
     ******************************************************************************************/
    public static final String SYS_APPINIT = "----> Iniciando Sistema";
    public static final String SYS_APPNOMBRE = "sys.app.nombre";
    public static final String SYS_APPTITULO = "sys.app.titulo";
    public static final String SYS_APPVERSION = "sys.app.version";
    public static final String SYS_APPDB = "sys.app.database";
    public static final String SYS_APPPATH = "sys.app.path";
    public static final String SYS_APPNIVEL = "sys.app.nivel";
    public static final String SYS_APPIMGPATH = "sys.app.imagepath";
    public static final String SYS_APPICON = "sys.app.icon";
    public static final String SYS_APPMENUICON = "sys.app.menu.icon";
    public static final String SYS_APPWELCOME = "BIENVENIDO";
    public static final String SYS_APPTXTERROR = "ERROR:";
    public static final String SYS_APPUIINIT = "Estableciendo interfaz de usuario principal";
    public static final String SYS_APPUIOK = "Interfaz de usuario principal establecida: OK";
    public static final String SYS_APPEVBINIT = "Estableciendo gestor de eventos principal";
    public static final String SYS_APPEVBOK = "Gestor de eventos principal establecido: OK";
    public static final String SYS_APP_REGEXP_CUIT = "^[0-9]{2}-[0-9]{8}-[0-9]$";
    public static final String SYS_APP_REGEXP_EMAIL = ".+@.+\\.[a-z]+";
    public static final String SYS_APP_CC = "[CC]";
    public static final String SYS_APP_ABS_PATH = "Path Absoluto ";
    public static final String SYS_APP_YES = "SI";
    public static final String SYS_APP_NO = "NO";

    /**********************************************************
     * Cadenas asociadas al manejo de formatos de fecha
     **********************************************************/
    public static final String SYS_APP_DATEFORMAT_VIEW = "dd/MM/yyyy";
    public static final String SYS_APP_DATEFORMAT_DB = "yyyy-MM-dd";
    public static final String SYS_APP_DATEFORMAT_LIST = "%1$td/%1$tm/%1$tY";
    public static final String SYS_APP_DATEFORMAT_REGEX = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";

    /**********************************************************
     * Cadenas de Login
     **********************************************************/
    public static final String SYS_APP_TXTLOGIN_USER = "Usuario";
    public static final String SYS_APP_TXTLOGIN_PASS = "Contraseña";
    public static final String SYS_APP_TXTLOGIN_SIGN = "INGRESAR";
    public static final String SYS_APP_TXTLOGIN_REMEM = "Recordarme";
    public static final String SYS_APP_TXTLOGIN_WELCOME = "Bienvenido a ";

    /**********************************************************
     * Cadenas de cambio de password
     **********************************************************/
    public static final String SYS_APP_CHANGEPASS_OLDPASS = "Contraseña Actual";
    public static final String SYS_APP_CHANGEPASS_NEWPASS = "Nueva Contraseña";
    public static final String SYS_APP_CHANGEPASS_REPPASS = "Repita Nueva Contraseña";
    public static final String SYS_APP_CHANGEPASS_ERR_DISTPASS = "LAS CONTRASEÑAS NUEVAS NO COINCIDEN";
    public static final String MSJ_APP_CHANGEPASS_ERR_ONCHANGE = "ERROR AL INTENTAR MODIFICAR LA CONTRASEÑA DEL USUARIO";
    public static final String MSJ_APP_CHANGEPASS_INF_CHANGEOK = "SE HA MODIFICADO LA CONTRASEÑA DEL USUARIO";

    /**********************************************************
     * Cadenas de manejos de sesiones
     **********************************************************/
    public static final String MSJ_SES_INF_LOGON = "INICIANDO SESION DE USUARIO";
    public static final String MSJ_SES_ERR_INITSESION = "ERROR AL INTENTAR INICIAR LA SESION DE USUARIO";
    public static final String MSJ_SES_ERR_SESIONEXIST = "YA EXISTE UNA SESION DE USUARIO CONECTADA";
    public static final String MSJ_SES_ERR_BADUSERPASS = "NOMBRE DE USUARIO O CONTRASEÑA INCORRECTAS";
    public static final String MSJ_SES_ERR_BADPASS = "LA CONTRASEÑA DEL USUARIO ES INCORRECTA";
    public static final String MSJ_SES_ERR_PRESESION = "SE INTENTO OBTENER SESION DE USUARIO ANTES DE INCIARSE";
    public static final String MSJ_SES_ERR_NOSESION = "ERROR AL INTENTAR ACCEDER A LA SESION DE USUARIO";
    public static final String MSJ_SES_INF_LOGOFF = "FINALIZANDO SESION DE USUARIO";

    /**********************************************************
     * Cadenas especiales comunes
     **********************************************************/
    public static final String SYS_CAD_NULL = "";
    public static final String SYS_CAD_LOGSEP = ":";
    public static final String SYS_CAD_NUMSEP = "-";
    public static final String SYS_CAD_BARRA = "/";
    public static final String SYS_CAD_SPACE = " ";
    public static final String SYS_CAD_COMMA = ",";
    public static final String SYS_CAD_FINLOG = ";";
    public static final String SYS_CAD_OPENTYPE = "[";
    public static final String SYS_CAD_CLOSETPE = "]";
    public static final String SYS_CAD_OPENPARS = "[";
    public static final String SYS_CAD_CLOSEPARS = "]";
    public static final String SYS_CAD_REFER = "->";
    public static final String SYS_CAD_REMARK = " ***** ";
    public static final String SYS_CAD_EXCLAM = "!!!!";
    public static final String SYS_CAD_LOGlLINE = "##############################################";
    public static final String SYS_CAD_UNSESION = "UNKNOW";
    public static final String SYS_CAD_NEW = "NUEVO";
    public static final String SYS_CAD_CRLF = "\n";
    public static final String SYS_APPLISTERROR = "ERROR:".concat(SYS_CAD_CRLF);
    public static final String SYS_CAD_TXTNULL = "NULO";
    public static final String SYS_CAD_TXTTOTAL = "TOTAL";
    public static final String SYS_CAD_TXTREGS = "REGISTROS";
    public static final String SYS_CAD_FECHADESDE = "Fecha Desde";
    public static final String SYS_CAD_FECHAHASTA = "Fecha Hasta";

    /**********************************************************
     * Cadenas de Mensajes del Logging comunes
     **********************************************************/
    public static final String MSJ_LOG_INF_INITLOGG = "INICIANDO SISTEMA DE LOGGING";
    public static final String MSJ_LOG_INF_ENDLOGG = "FINALIZANDO SISTEMA DE LOGGING";

    /**********************************************************
     * Cadenas de Mensajes de Seguridad comunes
     **********************************************************/
    public static final String MSJ_SEC_INF_INITSEC = "INICIANDO SISTEMA DE SEGURIDAD";
    public static final String MSJ_SEC_INF_NOACCES = "ACCESO AL RECURSO O FUNCION NO PERMITIDO";

    /**********************************************************
     * Cadenas de Mensajes de Error comunes
     **********************************************************/
    public static final String MSJ_ERR_ABSTRACT = "ERROR AL INTENTAR EJECUTAR COMPORTAMIENTO NO IMPLEMENTADO";
    public static final String MSJ_ERR_FATALINIT = "ERROR FATAL AL INICIAL EL SISTEMA";
    public static final String MSJ_ERR_EXCEPCION = "ERROR INTERNO DEL SISTEMA";
    public static final String MSJ_ERR_NOAPPNAME = "NOMBRE DE APLICACION NO ESTABLECIDO";
    public static final String MSJ_ERR_NOAPPTITLE = "TITULO DE APLICACION NO ESTABLECIDO";
    public static final String MSJ_ERR_NOAPPVERSION = "VERSION DE APLICACION NO ESTABLECIDA";
    public static final String MSJ_ERR_NOAPPDB = "BASE DE DATOS NO ESTABLECIDA";
    public static final String MSJ_ERR_NOAPPPATH = "PATH DE APLICACION NO ESTABLECIDO";
    public static final String MSJ_ERR_NOAPPIMAGE = "IMAGEN DE APLICACION NO ESTABLECIDA";
    public static final String MSJ_ERR_ATVERIFYDATA = "ERROR AL INTENTAR VALIDAR UN DATO";
    public static final String MSJ_ERR_TYPEPARAM = "ERROR AL INTENTAR ASIGNAR UN TIPO DE PARAMETRO NO PERMITIDO";
    public static final String MSJ_ERR_NULLFILTER = "ERROR AL INTENTAR USAR UN FILTRO NULO";

    /**********************************************************
     * Cadenas de Mensajes de AUDITORIA
     **********************************************************/
    public static final String MSJ_AUD_SAVEMARK = "ESTABLECIENDO MARCA DE AUDITORIA";
    public static final String MSJ_AYD_ERR_ATAUDITDATA = "ERROR AL ESTABLECER AUDITORIA SOBRE UN DATO";
    public static final String MSJ_AUD_MARKSAVED = "MARCA DE AUDITORIA REALIZADA";

    /**********************************************************
     * Cadenas de Mensajes de Errores de Vistas
     **********************************************************/
    public static final String MSJ_VIW_ERR_NONEWITEM = "ERROR AL INTENTAR INSTANCIAR UN NUEVO ITEM PARA LA VISTA";
    public static final String MSJ_VIW_ERR_CLASSITEM = "ERROR DE COINCIDENCIA DE TIPO DE ITEM PARA LA VISTA";
    public static final String MSJ_VIW_ERR_BADFORMATVIEW = "ERROR DE FORMAT DE UN ITEM VISUALIZADO";
    public static final String MSJ_ERR_TAB_WITHOUT_CONTENT = "ERROR AL INTENTAR CREAR UN TAB SIN CONTENIDO";


    /**********************************************************
     * Texto de Opciones generales de Menú del Sistema
     **********************************************************/
    public static final String SYS_MEN_ALIGN = "Ubicación de Menú";
    public static final String SYS_MEN_MENUCHPASS = "Modificar Contraseña";
    public static final String SYS_MEN_MENUEXIT = "Cerrar Sesión";

    /**********************************************************
     * Constantes de Mensajes de acciones del sistema
     **********************************************************/
    public static final String MSG_ACC_OPENVIEW = "Abriendo Vista del Sistema";
    public static final String MSG_ACC_INITVIEW = "Iniciando Vista del Sistema";
    public static final String MSG_ACC_SHOWFORM = "Mostrando Formulario";
    public static final String MSG_ACC_INITPREVIEW = "Iniciando Preview del Sistema";
    public static final String MSG_ACC_SETPREVIEW = "Estableciendo Preview a una Vista";
    public static final String MSG_ACC_SETFORMCRUD = "Estableciendo Form CRUD a una Vista";

    /**********************************************************
     * Constantes de botones de un CRUD
     **********************************************************/
    public static final String CRUD_MSG_DESCARTAR = "Descartar";
    public static final String CRUD_MSG_CANCELAR = "Cancelar";
    public static final String CRUD_MSG_GUARDAR = "Guardar";
    public static final String CRUD_MSG_GENERAR = "Generar";
    public static final String CRUD_MSG_ASOCIAR = "Asociar";
    public static final String CRUD_MSG_GUARCONT = "Guardar y Continuar";
    public static final String CRUD_FORM_BTN_AGREGAR = "Agregar";
    public static final String CRUD_FORM_BTN_EDITAR = "Agregar";
    public static final String CRUD_FORM_BTN_ELEGIR = "Seleccionar (ENT)";
    public static final String CRUD_FORM_BTN_CANCELAR = "Cancelar (F12)";
    public static final String CRUD_FORM_BTN_GUARDAR = "Guardar (F9)";
    public static final String CRUD_FORM_BTN_GUARADD = "Guardar y Agregar (F10)";
    public static final String CRUD_MSG_VER = "Ver (F3)";
    public static final String CRUD_MSG_AGREGAR = "Agregar (F4)";
    public static final String CRUD_MSG_EDITAR = "Editar (F5)";
    public static final String CRUD_MSG_BORRAR = "Eliminar (F6)";
    public static final String CRUD_MSG_PRINT = "Imprimir";
    public static final String CRUD_MSG_GEN_COMP = "Generar Comp.";
    public static final String CRUD_MSG_ANU_COMP = "Anular Comp.";
    public static final String CRUD_MSG_ASOC_PROV = "Asociar Prov.";
    public static final String CRUD_MSG_QUITAR = "Quitar";
    public static final String CRUD_MSG_BUSCAR = "Buscar";
    public static final String CRUD_MSG_LIMPIAR = "Buscar";
    public static final String CRUD_MSG_CAMBIAR = "Cambiar";
    public static final String CRUD_MSG_CONFIG = "Configurar (F5)";

    /**********************************************************
     * Cadenas de mensajes de consultas al usuario
     **********************************************************/
    public static final String CRUD_MSG_BOXSAVE = "Desea guardar los cambios de este Registro?";
    public static final String CRUD_MSG_BOXSAVEPPAL = "Desea guardar los cambios al Registro Principal?";
    public static final String CRUD_MSG_BOXDEL = "Desea eliminar este Registro?";
    public static final String CRUD_MSG_BOXQUITL = "Desea quitar este Registro de la lista?";
    public static final String CRUD_MSG_BOXCANCEL = "Desea descartar los cambios de este Registro?";
    public static final String CRUD_MSG_BOXOK = "Los datos han sido guardados correctamente!";

    /**********************************************************
     * Cadenas de mensajes de manejo de eventos
     **********************************************************/
    public static final String EVB_REGISTER = "Registrando Fuente de Eventos";
    public static final String EVB_POST = "Evento Lanzado al Manejador de Eventos";
    public static final String EVB_UNREGISTER = "DESRegistrando Fuente de Eventos";

    /**********************************************************
     * Cadenas de mensajes del MENU
     **********************************************************/
    public static final String MSJ_INF_INIT_MENUSERV = "INICIANDO SERVICIO DE MENU";
    public static final String SYS_INF_MENU_INIT = "Iniciando el menu del sistema...";
    public static final String SYS_MENU_ERR_NOEXISTS = "NO SE HA IMPLEMENTADO UNA OPCION DE MENU";
    public static final String SYS_MENU_ERR_ONBUILD = "ERROR AL CONSTRUIR EL MENU DEL USUARIO";
    public static final String SYS_CFG_MENU_PREFIJO = "MENU.%";
    public static final Long SYS_CFG_MENU_IDINI = 0L;
    public static final String SYS_CFG_MENU_SEPARATOR = "-";

    /**********************************************************
     * Cadenas de Mensajes de Errores de persistencia
     **********************************************************/
    public static final String MSJ_ERR_ATCONSVALDATA = "ERROR AL VALIDAR UNA ENTIDAD AL INTENTAR PERSISTIR:";
    public static final String MSJ_ERR_ATSAVEDATA = "ERROR AL INTENTAR PERSISTIR UN DATO";
    public static final String MSJ_ERR_ATDELDATA = "ERROR AL INTENTAR ELIMINAR UN DATO";
    public static final String MSJ_ERR_ATUNDELDATA = "ERROR AL INTENTAR REACTIVAR UN DATO";
    public static final String MSJ_ERR_ATREFRESHDATA = "ERROR AL INTENTAR RECARGAR UN DATO";
    public static final String MSJ_ERR_ATLOADDATA = "ERROR AL INTENTAR CARGAR UN DATO";
    public static final String MSJ_ERR_OPTIMISTLOCK = "ERROR DE BLOQUEO OPTIMISTA EN EL MOTOR DE PERSISTENCIA!";
    public static final String MSJ_ERR_CONSTRAINTVIOLATION = "ERROR DE VIOLACION DE RESTRICCION DE DATOS!";
    public static final String MSJ_ERR_TARGETINVOCATION = "ERROR DE CONFIGURACION DE ENTIDADES DE PERSISTENCIA";
    public static final String MSJ_ERR_SQLEXEC = "ERROR AL EJECUTAR CONSULTA AL MOTOR DE PERSISTENCIA";
    public static final String MSJ_ERR_GENERICEXCEPTION = "ERROR GENERICO DE PERSISTENCIA";
    public static final String MSJ_ERR_VERIFYEXCEPTION = "ERROR DETERMINANDO EL TIPO DE EXCEPCION DE PERSISTENCIA";
    public static final String MSJ_ERR_VRFYCVEXCEPTION = "ERROR DETERMINANDO LA EXCEPCION 'CONSTRAINT VALIDATION'";
    public static final String MSJ_ERR_VRFYTIEXCEPTION = "ERROR DETERMINANDO LA EXCEPCION 'TARGET INVOCATION'";

    /**********************************************************
     * Cadenas de Mensajes de errores con Entidades
     **********************************************************/
    public static final String MSJ_DB_LOADDATA = "OBTENIENDO ENTIDAD";
    public static final String MSJ_DB_SAVEDATA = "PERSISTIENDO ENTIDAD";
    public static final String MSJ_DB_ALTERDATA = "PERSISTIENDO ACTUALIZACION";
    public static final String MSJ_DB_REFRESHDATA = "REFRESCANDO ENTIDAD";
    public static final String MSJ_DB_DELDATA = "ELIMINANDO ENTIDAD";
    public static final String MSJ_DB_DELSDATA = "ELIMINANDO ENTIDADES";

    /**********************************************************
     * Cadenas de Mensajes de Errores de campos de base de datos
     **********************************************************/
    public static final String MSJ_ERR_DB_FIELD_EMPTY = "DEBEN CARGARSE DATOS PARA EL CAMPO OBLIGATORIO: ";
    public static final String MSJ_ERR_DB_FIELD_NOK = "DEBEN CARGARSE DATOS VALIDOS PARA EL CAMPO: ";
    public static final String MSJ_ERR_DB_FIELD_LONGNOK = "LA LONGITUD DE DATOS INGRESADOS ES INVALIDA PARA EL CAMPO: ";
    public static final String MSJ_ERR_DB_ADDFIELD_NULL = "EL ELEMENTO QUE DESEA AGREGAR ES NULO!";
    public static final String MSJ_ERR_DB_EDITFIELD_NULL = "EL ELEMENTO QUE DESEA EDITAR ES NULO!";
    public static final String MSJ_ERR_DB_DELFIELD_NULL = "EL ELEMENTO QUE DESEA QUITAR ES NULO!";
    public static final String MSJ_ERR_DB_ATT_EXIST = "EL ELEMENTO QUE SE DESEA AGREGAR YA SE ENCUENTRA AGREGADO!";
    public static final String MSJ_ERR_DB_PARAMTYPE = "EL ATRIBUTO QUE DESEA APLICAR NO TIENE EL TIPO CORRECTO!";
    public static final String MSJ_ERR_DB_PARAMVALUE = "EL ATRIBUTO QUE DESEA APLICAR NO TIENE EL VALOR CORRECTO!";
    public static final String MSJ_ERR_DB_EDITFIELD = "NO SE PUEDE ELIMINAR EL ELEMENTO DE LA BASE DE DATOS!";
    public static final String MSJ_ERR_DB_VERIFYFIELD = "SE HAN DETECTADO ERRORES VALIDANDO LA CARGA DE DATOS!";
    public static final String MSJ_ERR_DB_ATSAVEDATA = "SE HAN DETECTADO ERRORES GUARDANDO LOS DATOS!";

    /**********************************************************
     * Cadenas de Mensajes de Errores de conversion de campos
     **********************************************************/
    public static final String MSJ_ERR_DB_ATCONVERTDATA = "SE HAN DETECTADO ERRORES CONVIERTIENDO TIPOS DE DATOS: ";
    public static final String MSJ_ERR_DB_NEEDINTEGER = "DEBE INGRESAR UN NUMERO ENTERO!";
    public static final String MSJ_ERR_DB_NEEDDOUBLE = "DEBE INGRESAR UN NUMERO DECIMAL!";
    public static final String MSJ_ERR_DB_NEEDDATE = "DEBE INGRESAR UNA FECHA VALIDA!";

    /************************************************************
     * Cadenas de Mensajes de Errores especificos de base de datos
     ***********************************************************/
    public static final String MSJ_ERR_DB_PARAM_NOEXIST = "EL PARAMETRO O RECURSO DESEADO NO EXISTE!";
    public static final String MSJ_ERR_DB_PERMISO_NOEXIST = "EL PERMISO QUE SE DESEA AGREGAR O VERIFICAR NO EXISTE!";
    public static final String MSJ_ERR_DB_PERMISO_EXIST = "EL PERMISO QUE SE DESEA AGREGAR YA SE ENCUENTRA AGREGADO!";

    /**********************************************************
     * Cadenas de Mensajes de las Vistas del Sistema
     **********************************************************/
    public static final String MSJ_ERR_FCNOTPREENT = "LA FUNCIONALIDAD NO HA SIDO IMPLEMENTADA";
    public static final String MSJ_ERR_CANTFOCUS = "NO SE PUDO DAR FOCO A UN ATRIBUTO DE LA VISTA";
    public static final String MSJ_ERR_PREVIEWNOVER = "SE INTENTO ABRIR UN PREVIEW EN MODO DISTINTO A VER";
    public static final String MSJ_ERR_NOFORM = "ERROR DETERMINANDO EL FORMULARIO A UTILIZAR";
    public static final String MSJ_ERR_NOPREVIEW = "ERROR DETERMINANDO EL PREVIEW A UTILIZAR";
    public static final String MSJ_ERR_NOFATHER = "ERROR DETERMINANDO EL OBJETO INICIADOR A UTILIZAR";
    public static final String MSJ_ERR_BADMODE = "SE HA INTENTADO UTILIZAR UN MODO DE VISTA NO ACEPTADO (SERA TANSFORMADO A 'VER')";
    public static final String MSJ_ERR_CANTOPENVIEW = "HAY ERRORES EN LA CARGA DEL REGISTRO PRICINPAL, POR FAVOR REVISE LOS DATOS INGRESADOS";
    public static final String MSJ_ERR_CS_NOITEM = "NO HAY UN ITEM PARA MOSTRAR";
    public static final String MSJ_ERR_CS_CANTSHOW_ITEM = "NO SE HA PODIDO MOSTRAR EL ELEMENTO";
    public static final String MSJ_ERR_CS_CANTSHOW_SELECT = "NO SE HA PODIDO ABRIR LA VENTANA DE SELECCION";
    public static final String MSJ_ERR_CS_CANTDEL_SELECT = "NO SE PUEDE BLANQUEAR EL CAMPO SELECCIONADO";
    public static final String MSJ_ERR_CS_CANTSET_SELECT = "NO SE PUEDE ESTABLECER EL VALOR DE LOS CAMPOS DEPENDIENTES";
    public static final String MSJ_ERR_CS_CANTSHOW_FORM = "NO SE HA PODIDO ABRIR LA VENTANA DE EDICION";
    public static final String MSJ_ERR_BAD_PATH = "NO SE HA PODIDO UBICAR EL DIRECTORIO REQUERIDO";
    public static final String MSJ_ERR_TOOBIG_FILE = "EL ARCHIVO QUE INTENTA TRABAJAR ES DEMASIADO GRANDE";
    public static final String MSJ_ERR_ONWORK_FILE = "ERROR AL INTENTAR TRABAJAR CON EL DIRECTORIO/ARCHIVO QUE INTENTA UTILIZAR";

    /**********************************************************
     * Constantes de Titulos de Ventanas
     **********************************************************/
    public static final String WIN_TIT_GENERICO = "SIDDIRE";
    public static final String WIN_TIT_SAVEREG = "GUARDAR REGISTRO";
    public static final String WIN_TIT_SAVEREGPPAL = "GUARDAR REGISTRO PRINCIPAL";
    public static final String WIN_TIT_DELREG = "BORRAR REGISTRO";
    public static final String WIN_TIT_QUITREG = "QUITAR REGISTRO";
    public static final String WIN_TIT_DESCARTREG = "DESCARTAR CAMBIOS";
    public static final String WIN_TIT_CHANGEPASS = "MODIFICAR CONTRASEÑA";
    public static final String WIN_TIT_CHANGEMENU = "MODIFICAR UBICACION DE MENU";
    public static final String WIN_TIT_SHOWIMAGE = "MOSTRAR IMAGEN";

    /**********************************************************
     * Cadenas de manejos de reportes
     **********************************************************/
    public static final String MSJ_REP_INF_SETBASEPATH = "ESTABLECIENDO DIRECTORIO BASE DEL REPORTE";
    public static final String MSJ_REP_INF_BASEPATH = "DIRECTORIO BASE DEL REPORTE ESTABLECIDO";
    public static final String MSJ_REP_ERR_NOBASEPATH = "ERROR AL INTENTAR ESTABLECER DIRECTORIO BASE DEL REPORTE";
    public static final String MSJ_REP_INF_INITPARES = "INICIANDO CARGA DE ARCHVO TEMPLATE DEL REPORTE";
    public static final String MSJ_REP_INF_LOAD = "CARGANDO ARCHVO TEMPLATE DEL REPORTE";
    public static final String MSJ_REP_INF_LOADOK = "ARCHVO TEMPLATE DEL REPORTE CARGADO CORRECTAMENTE";
    public static final String MSJ_REP_ERR_CANTREADTEMPLATE = "ERROR AL INTENTAR LEER EL ARCHVO TEMPLATE DEL REPORTE";
    public static final String MSJ_REP_ERR_CANTLOADTEMPLATE = "ERROR AL INTENTAR ENCONTRAR EL ARCHVO TEMPLATE DEL REPORTE";
    public static final String MSJ_REP_INF_COMPILE = "CARGANDO ARCHVO TEMPLATE DEL REPORTE";
    public static final String MSJ_REP_INF_COMPILEOK = "ARCHVO TEMPLATE DEL REPORTE CARGADO CORRECTAMENTE";
    public static final String MSJ_REP_ERR_COMPILETEMPLATE = "ERROR AL INTENTAR COMPILAR EL ARCHVO TEMPLATE DEL REPORTE";
    public static final String MSJ_REP_INF_COMPLETE = "COMBINANDO DATOS DEL REPORTE";
    public static final String MSJ_REP_INF_COMPLETEOK = "REPORTE COMBINADO CON DATOS CORRECTAMENTE";
    public static final String MSJ_REP_ERR_COMPLETE = "ERROR AL INTENTAR RELLENAR LOS DATOS EN EL REPORTE";
    public static final String MSJ_REP_ERR_NOEXPORT = "ERROR AL INTENTAR EXPORTAR EL REPORTE";
    public static final String MSJ_REP_EXPORT_PDF = "EXPORTANDO REPORTE A PDF";
    public static final String MSJ_REP_EXPORT_XLS = "EXPORTANDO REPORTE A EXCEL";
    public static final String MSJ_REP_GENERATING_REPORT = "Generando Reporte...";
    public static final String MSJ_REP_GENERATING_REPORT_OK = "Reporte generado correctamente";
    public static final String MSJ_REP_GENERATE_PREOUT_STRING = "_";
    public static final String MSJ_REP_GENERATE_POSOUT_PDF = ".pdf";
    public static final String MSJ_REP_GENERATE_POSOUT_XLS = ".xls";

}
