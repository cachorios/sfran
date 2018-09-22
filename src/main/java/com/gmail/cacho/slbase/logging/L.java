package com.gmail.cacho.slbase.logging;


import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;

public abstract class L {
    public static void info(String mensaje) {
        info(mensaje, null);
    }

    public static void info(String mensaje, String extra) {
        if (extra != null) {
            LogService.getLog().logear(ENivelAplicacion.INFO, mensaje, extra);
        } else {
            LogService.getLog().logear(ENivelAplicacion.INFO, mensaje);
        }
    }

    public static void error(String mensaje) {
        error(mensaje, null);
    }

    public static void error(String mensaje, String extra) {
        if (extra != null) {
            LogService.getLog().logear(ENivelAplicacion.ERROR, mensaje, extra);
        } else {
            LogService.getLog().logear(ENivelAplicacion.ERROR, mensaje);
        }
    }

    public static void sistema(String mensaje) {
        sistema(mensaje, null);
    }

    public static void sistema(String mensaje, String extra) {
        if (extra != null) {
            LogService.getLog().logear(ENivelAplicacion.SISTEMA, mensaje, extra);
        } else {
            LogService.getLog().logear(ENivelAplicacion.SISTEMA, mensaje);
        }
    }

    public static void batch(String mensaje) {
        batch(mensaje, null);
    }

    public static void batch(String mensaje, String extra) {
        if (extra != null) {
            LogService.getLog().logear(ENivelAplicacion.BATCH, mensaje, extra);
        } else {
            LogService.getLog().logear(ENivelAplicacion.BATCH, mensaje);
        }
    }

    public static void warning(String mensaje) {
        warning(mensaje, null);
    }

    public static void warning(String mensaje, String extra) {
        if (extra != null) {
            LogService.getLog().logear(ENivelAplicacion.WARNING, mensaje, extra);
        } else {
            LogService.getLog().logear(ENivelAplicacion.WARNING, mensaje);
        }
    }
}
