package com.gmail.cacho.slapi.dialogs;


import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.cacho.slbase.security.excepciones.SecurityErrorException;
import com.vaadin.cdi.annotation.UIScoped;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.SimpleByteSource;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;


@UIScoped
public class WinChangePass extends Dialog {
    PasswordField oldpass, password, password2;
    Button cambiar, cancelar;

    public WinChangePass() {
        super();
        armarVentana();
    }

    private void armarVentana() {
        setCloseOnEsc(false);
        setCloseOnOutsideClick(false);
        setWidth("300px");
        setHeight("400px");

        VerticalLayout globallayout = new VerticalLayout();
        globallayout.setClassName("v-form");
        globallayout.setSpacing(false);
        globallayout.setMargin(false);
        globallayout.setPadding(false);
        globallayout.setAlignItems(FlexComponent.Alignment.CENTER);

        H4 titulo = new H4(Constantes.SYS_MEN_MENUCHPASS);
        titulo.setClassName("titulo");
        //titulo.setWidth("100%");
        globallayout.add(titulo);

        Component f = buildFields();
        globallayout.add(f);

        Component b = buildBotonera();
        globallayout.add(b);

        add(globallayout);
    }

    private Component buildFields() {
        VerticalLayout fields = new VerticalLayout();
        fields.setWidth("100%");

        oldpass = new PasswordField(C.SYS_APP_CHANGEPASS_OLDPASS);
        oldpass.addValueChangeListener(e -> onChangeText());

        password = new PasswordField(C.SYS_APP_CHANGEPASS_NEWPASS);
        password.addValueChangeListener(e -> onChangeText());

        password2 = new PasswordField(C.SYS_APP_CHANGEPASS_REPPASS);
        password2.addValueChangeListener(e -> onChangeText());

        fields.add(envolver(oldpass, "100%"),
                   envolver(password, "100%"),
                   envolver(password2, "100%"));

        return fields;
    }

    private Component buildBotonera() {
        cambiar = new Button(Constantes.CRUD_MSG_CAMBIAR, e -> cambiarPass());
        //cambiar.setShortcut(ShortcutAction.KeyCode.ENTER);
        cambiar.setWidth("100px");
        cambiar.setEnabled(false);

        cancelar = new Button(Constantes.CRUD_MSG_CANCELAR, clickEvent -> close());
        //cancelar.setClickShortcut(ShortcutAction.KeyCode.ESCAPE);
        cancelar.setWidth("100px");

        HorizontalLayout botonera = new HorizontalLayout();
        botonera.setWidth("100%");
        botonera.setHeight("30px");
        botonera.add(cambiar, cancelar);

        return botonera;
    }

    private void cambiarPass() {
        try {
            if (!estaUsuarioLogeado()) {
                throw new SecurityErrorException(Constantes.MSJ_SES_ERR_NOSESION);
            }

            if (!esPasswordCorrecta(oldpass.getValue())) {
                throw new SecurityErrorException(Constantes.MSJ_SES_ERR_BADPASS);
            }

            if (!sonPasswordsCoincidentes(password.getValue(), password2.getValue())) {
                throw new SecurityErrorException(Constantes.SYS_APP_CHANGEPASS_ERR_DISTPASS);
            }

            Usuario user = Sistema.getSistema().getSecurityControl().getUsuarioActivo();
            SimpleByteSource sbs = new SimpleByteSource(user.getUsername().concat(Sistema.getSistema().getPreSalt()));
            String pass = new Sha256Hash(password.getValue(), sbs, 1024).toBase64();
            user.setPassword(pass);
            //// todo: persist
            // //CDI.current().select(UsuarioServicio.class).get().persist(user);
            Sistema.getSistema().mostrarMensaje(ENivelAplicacion.INFO, Constantes.MSJ_APP_CHANGEPASS_INF_CHANGEOK, null);
            close();
        ///} catch (SecurityErrorException | PersistErrorException ex) {
        } catch (SecurityErrorException  ex) {
            Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_APP_CHANGEPASS_ERR_ONCHANGE, ex.getSimpleMenssage());
        }
    }

    private boolean estaUsuarioLogeado() {
        return Sistema.getSistema().getSecurityControl().isUserSignedIn();
    }

    private boolean sonPasswordsCoincidentes(String pass, String pass2) {
        return (pass.equals(pass2));
    }

    private boolean esPasswordCorrecta(String oldpass) {
        return Sistema.getSistema().getSecurityControl().getUsuarioActivo().isPasswordOK(oldpass);
    }

    private void onChangeText() {
        cambiar.setEnabled(!(password.isEmpty() || password2.isEmpty() || oldpass.isEmpty()));
    }
}
