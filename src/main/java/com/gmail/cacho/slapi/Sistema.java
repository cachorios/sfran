package com.gmail.cacho.slapi;


import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.seguridad.general.PrincipalMapper;
import com.gmail.cacho.backend.seguridad.general.SlbaseAccessControl;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.cacho.slbase.core.interfaces.IControladorSistema;
import com.gmail.cacho.slbase.logging.L;
import com.gmail.cacho.slbase.logging.LogService;
import com.gmail.cacho.slbase.security.interfaces.IControladorSeguridad;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.server.VaadinSession;
import org.apache.shiro.SecurityUtils;

import org.claspina.confirmdialog.ButtonOption;
import org.claspina.confirmdialog.ConfirmDialog;

import javax.enterprise.inject.spi.CDI;
import java.io.IOException;
import java.util.Properties;

/**
 * En el framework ad-hoc de SCIO, esta clase Sistema es la que representa al sistema y a todos los servs
 * centrales que una aplicación deberá proveer. Implementa la interfaz IControladorSistema y utiliza el patron
 * Singleton para controlar que exista una sola instancia del mismo corriendo. Esta clase posee metodos utiles
 * para iniciar y proveer servs de: recoleccion de parametros, verificacion de integridad, logging, etc.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class Sistema implements IControladorSistema<SistemaUI, EventManager> {
    private final static String CONFIG_FILE_NAME = "sistema.properties";
    private static Sistema _sistema = null;
    private static SistemaUI _ui = null;
    private static EventManager _eb = null;
    private Properties properties = null;
    private final static String _presalt = "JNGovdvRJNIzY7TUmnLUEQ==";
    private PrincipalMapper principalMapper;



    /**
     * Constructor que carga efectivamente las propiedades del sistema.
     */
    private Sistema() {
        this.properties = new Properties();
        try {
            properties.load(Sistema.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Implementa el modo Singleton para la clase Sistema.
     *
     * @return La instancia de Sistema bajo utilizacion.
     */
    public static Sistema getSistema() {
        if (_sistema == null) {
            _sistema = new Sistema();
        }
        return _sistema;
    }

    @Override
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    @Override
    public ENivelAplicacion getNivelAplicacion() {
        return ENivelAplicacion.valueOf(this.properties.getProperty(Constantes.SYS_APPNIVEL));
    }

    @Override
    public String getNombre() {
        return getProperty(Constantes.SYS_APPNOMBRE);
    }

    @Override
    public String getTitulo() {
        return getProperty(Constantes.SYS_APPTITULO);
    }

    @Override
    public String getVersion() {
        return getProperty(Constantes.SYS_APPVERSION);
    }

    @Override
    public String getDatabase() {
        return getProperty(Constantes.SYS_APPDB);
    }

    @Override
    public String getPath() {
        return getProperty(Constantes.SYS_APPPATH);
    }

    @Override
    public String getIcon() {
        return getProperty(Constantes.SYS_APPICON);
    }

    @Override
    public String getMenuIcon() {
        return getProperty(Constantes.SYS_APPMENUICON);
    }

    @Override
    public String getImagePath() {
        return getProperty(Constantes.SYS_APPIMGPATH);
    }

    @Override
    public void iniciar(SistemaUI ui, EventManager eventbus) {
        L.sistema(Constantes.SYS_APPINIT, Constantes.SYS_CAD_REMARK.concat(Sistema.getSistema().getNombre().toUpperCase()).concat(Constantes.SYS_CAD_REMARK));
        L.info(Constantes.SYS_APPNOMBRE, Sistema.getSistema().getNombre());
        L.info(Constantes.SYS_APPTITULO, Sistema.getSistema().getTitulo());
        L.info(Constantes.SYS_APPVERSION, Sistema.getSistema().getVersion());
        L.info(Constantes.SYS_APPDB, Sistema.getSistema().getDatabase());
        L.info(Constantes.SYS_APPPATH, Sistema.getSistema().getPath());
        L.info(Constantes.SYS_APPNIVEL, Sistema.getSistema().getNivelAplicacion().toString());
        L.info(Constantes.SYS_APPUIINIT, ui.toString());

        // establece la interfazde usuario
        _ui = ui;
        L.info(Constantes.SYS_APPUIOK);
        L.info(Constantes.SYS_APPEVBINIT, eventbus.toString());

        // establece el manejador de eventos
        _eb = eventbus;

        L.info(Constantes.SYS_APPEVBOK);
    }

    @Override
    public SistemaUI getUIPpal() {
        return _ui;
    }

    @Override
    public EventManager getEventBus() {
        return _eb;
    }

    @Override
    public void logon() {
        VaadinSession.getCurrent().setAttribute(Usuario.class.getName(), getSecurityControl().getNombreDeUsuarioActivo());
    }

    @Override
    public void logoff() {
        getSecurityControl().logoff();
        UI.getCurrent().getPage().executeJavaScript("window.location.href='/'");
    }

    @Override
    final public void mostrarMensaje(ENivelAplicacion nivel, String mensaje, String desc) {
        Notification notification;

        if (nivel.equals(ENivelAplicacion.ERROR)) {
//            notification = new Notification(getProperty(Constantes.SYS_APPNOMBRE), mensaje, Notification:: );
            notification = new Notification( mensaje );
            L.error(mensaje, desc);
        } else {
            notification = new Notification( mensaje);
//            notification = new Notification(getProperty(Constantes.SYS_APPNOMBRE), mensaje);
        }

        if (desc != null && !desc.isEmpty()) {
            notification.add(new Span("<span>".concat(desc).concat("</span>")));
            //notification.setDescription("<span>".concat(desc).concat("</span>"));
        }

//        notification.setHtmlContentAllowed(true);
        notification.setPosition(Notification.Position.BOTTOM_CENTER);
//        notification.setDelayMsec(5000);

    }

    @Override
    final public void mostrarBoxConsultaSiNo(String titulo, String mensaje, String textYes, String textNo, Runnable onYes) {
        ConfirmDialog
                .createQuestion()
                .withCaption(titulo)
                .withMessage(mensaje)
                .withOkButton(onYes, ButtonOption.focus(), ButtonOption.caption(Constantes.SYS_APP_YES))
                .withCancelButton(ButtonOption.caption(Constantes.SYS_APP_NO))
                .open();
    }

    @Override
    public String getPreSalt() {
        return _presalt;
    }

    @Override
    public void finalizar() {
        LogService.getLog().terminar();
    }


    @Override
    public SlbaseAccessControl getSecurityControl() {
        return CDI.current().select(SlbaseAccessControl.class).get();
    }

    @Override
    public String getNombreUsuarioActivo() {
        return  principalMapper.getUsername( SecurityUtils.getSubject().getPrincipals());
    }

    public void setPrincipalMapper(PrincipalMapper principal) {
        this.principalMapper = principal;
    }
}
