package com.gmail.cacho.slbase.logging;



import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.cacho.slbase.logging.interfaces.IControladorLogging;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta es la clase del framework que implementa el servicio de logging a un destino de log como archivo
 * de texto y basado en el esquema de TOMEE (juli), pero modificado para simplificar aun mas la salida
 * del texto. Se implementa la Interface IControladorLogging.
 *
 * @author jmfragueiro
 * @version 20161011

 */
public class LogService implements IControladorLogging {
    private static LogService _log = null;
    private static ENivelAplicacion _nivel = ENivelAplicacion.NINGUNO;

    /**
     * Constructor que inicia efectivamente el logging del sistema.
     */
    private LogService() {
        _nivel = Sistema.getSistema().getNivelAplicacion();
        this.iniciar();
    }

    /**
     * Implementa el modo Singleton para la clase LogSistema.
     *
     * @return La instancia de gestor de logging bajo utilizacion.
     */
    public static LogService getLog() {
        if (_log == null) {
            _log = new LogService();
        }

        return _log;
    }

    private void iniciar() {
        logear(ENivelAplicacion.SISTEMA, C.SYS_CAD_LOGlLINE);
        logear(ENivelAplicacion.SISTEMA, Constantes.MSJ_LOG_INF_INITLOGG);
        logear(ENivelAplicacion.SISTEMA, Constantes.SYS_CAD_REMARK.concat(Sistema.getSistema().getProperty(Constantes.SYS_APPNOMBRE))
                                                                  .concat(Constantes.SYS_CAD_REMARK));
        logear(ENivelAplicacion.SISTEMA, LocalDateTime.now().toString());
        logear(ENivelAplicacion.SISTEMA, C.SYS_CAD_LOGlLINE);
    }

    @Override
    public void logear(String mensaje) {
        logear(Sistema.getSistema().getNivelAplicacion(), mensaje, null);
    }

    @Override
    public void logear(String mensaje, String extra) {
        logear(Sistema.getSistema().getNivelAplicacion(), mensaje, extra);
    }

    @Override
    public void logear(ENivelAplicacion nivel, String mensaje) {
        logear(nivel, mensaje, null);
    }

    @Override
    public void logear(ENivelAplicacion nivel, String mensaje, String extra) {
        if (_nivel.compareTo(nivel) <= 0) {
            Logger.getLogger(LogService.class.getName()).log(Level.SEVERE,
                                                             C.SYS_CAD_OPENTYPE + nivel.toString().toUpperCase() + C.SYS_CAD_CLOSETPE
                                                                     + Constantes.SYS_CAD_LOGSEP + mensaje + C.SYS_CAD_SPACE + (
                                                                     (extra != null) ? extra : Constantes.SYS_CAD_NULL));
        }
    }

    @Override
    public void terminar() {
        logear(_nivel, C.SYS_CAD_LOGlLINE, null);
        logear(_nivel, Constantes.MSJ_LOG_INF_ENDLOGG, null);
        logear(_nivel, Constantes.SYS_CAD_REMARK + Constantes.SYS_APPNOMBRE + Constantes.SYS_CAD_REMARK, null);
        logear(_nivel, LocalDateTime.now().toString(), null);
        logear(_nivel, C.SYS_CAD_LOGlLINE, null);
    }
}