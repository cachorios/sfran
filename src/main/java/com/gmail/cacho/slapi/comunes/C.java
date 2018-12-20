package com.gmail.cacho.slapi.comunes;


import com.gmail.cacho.slbase.core.Constantes;

import java.util.Date;

public class C extends Constantes {
    /**********************************************************
     * Constantes de directorios comunes
     **********************************************************/
    public static final String SYS_DIR_WEBINF = "/WEB-INF";

    /**********************************************************
     * Constantes del sistema de reportes (jasper)
     **********************************************************/
    public static final String SYS_REP_COMPILE_TMP_PROPERTY = "jasper.reports.compile.temp";
    public static final String SYS_REP_TITULO = "TRIADE S.A.";
    public static final String SYS_REP_CUIT = "xxxxxxxxxxx";
    public static final String SYS_REP_DIRECCION = "LA RIOJA 1635";
    public static final String SYS_REP_DIR_BASE = "/reportes";

    /**********************************************************
     * Constantes de parametros del sistema de reportes (jasper)
     **********************************************************/
    public static final String SYS_REP_PARAM_ID = "p_Id";
    public static final String SYS_REP_PARAM_DIRECTORIO = "p_Directorio";
    public static final String SYS_REP_PARAM_SUBREPORTE = "p_Subreporte";
    public static final String SYS_REP_PARAM_FECHA_INICIAL = "p_FechaInicial";
    public static final String SYS_REP_PARAM_FECHA_FINAL = "p_FechaFinal";
    public static final String SYS_REP_PARAM_TIPO_INSUMO = "p_TipoInsumo";
    public static final String SYS_REP_PARAM_TITULO = "reporteTitulo";
    public static final String SYS_REP_PARAM_DIRECCION = "reporteDire";
    public static final String SYS_REP_PARAM_IGNORE_PAG = "IS_IGNORE_PAGINATION";

    /**********************************************************
     * Constantes de nombres de template del sistema de reportes (jasper)
     **********************************************************/
    public static final String SYS_REP_TEMPLATE_LIBROIVA = "libroIva.jrxml";
    public static final String SYS_REP_TEMPLATE_LIBROIVA_NAME = "LibroIvaVentas";

    public static final String SYS_REP_TEMPLATE_COMPROBANTE = "compfactura.jrxml";
    public static final String SYS_REP_TEMPLATE_COMPROBANTE_NAME = "Comprobante";

    /**********************************************************
     * Constantes de botones de un CRUD
     **********************************************************/
    public static final String CRUD_MSG_BOXGENCOMP = "Desea confirmar la carga y Generar el Comprobante?";
    public static final String CRUD_MSG_BOXANUCOMP = "Desea anular el Comprobante y reabrir Ingreso?";
    public static final String CRUD_MSG_BOXASOCPROV = "Desea Asociar un nuevo Proveedor al Título?";

    /**********************************************************
     * Cadenas de Mensajes Especificos del Modelo en las Vistas del Sistema
     **********************************************************/
    public static final String CRUD_ERR_FALTANTE_OVERFLOW = "La Cantidad de Faltante no puede ser mayor a lo Ingresado";
}
