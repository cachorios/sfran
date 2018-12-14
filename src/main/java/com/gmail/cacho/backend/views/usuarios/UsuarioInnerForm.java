package com.gmail.cacho.backend.views.usuarios;

import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.cacho.slapi.view.utils.ViewTools;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.*;
import com.vaadin.flow.data.validator.BeanValidator;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import com.gmail.cacho.backend.seguridad.shiro.HashConfig;

import static com.gmail.cacho.slapi.view.utils.ViewTools.*;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class UsuarioInnerForm extends DefaultInnerDialog<Usuario> {


    private boolean passwordRequired;
    private Binder.Binding<Usuario, String> passwordBinding;
    private Binder.Binding<Usuario, String> confirmPasswordBinding;
    private RandomNumberGenerator rng;

    private Validator<String> passwordValidator = new Validator<String>() {
        BeanValidator passwordBeanValidator = new BeanValidator(Usuario.class, "password");

        @Override
        public ValidationResult apply(String value, ValueContext context) {
            if (!passwordRequired && value.isEmpty()) {
                //como no se cargo clave y no es requerido entonces la validacion es correcta
                return ValidationResult.ok();
            } else {
                return passwordBeanValidator.apply(value, context);
            }
        }
    };

    private TextField username;
    private TextField nombre;
    private TextField legajo;
    private TextField email;

    private TextField role;

    private PasswordField password;
    private PasswordField passwordConfirm;
//    private MuchoaMuchoGrid<Rol> roles;

    public UsuarioInnerForm(IPresentableForm<Usuario> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    private boolean ValidarConfirmPassword(String valor) {
        HasValue<?, ?> pws = passwordBinding.getField();
        if (valor.isEmpty() && ((String) pws.getValue()).isEmpty()) {
            return true;
        }

        return Objects.equals(pws.getValue(), valor);
    }

    public void setPasswordRequired(boolean passwordRequired) {
        this.passwordRequired = passwordRequired;
    }

    @Override
    protected void generarForm(Div form) {
//        setTabsHeigth("150px");
//        ServRol servRol = CDI.current().select(ServRol.class).get();

        username = textField("Usuario");
        nombre = textField("Nombre");
        email = textField("Email");
        password = new PasswordField("Contraseña");
        password.setWidth("100%");
        password.setHeight(ViewTools.ALTO_DEFAULT);

        passwordConfirm = new PasswordField("Confime la clave");
        passwordConfirm.setWidth("100%");
        passwordConfirm.setHeight(ViewTools.ALTO_DEFAULT);

        role = textField("Roles");

//        roles = new MuchoaMuchoGrid<Rol>(servRol.getAll());
//
//        roles.addColumn(Rol::getNombre, "Rol")
//            .addColumn(Rol::getDescripcion, "Descripción")
//            .altoFila("220px")
//             //                .sizeFull()
//            .leyendaIzquierdo("Disponible").leyendaDerecha("Seleccionado");

        form.add(
                envolver(username, "49%")
                ,envolver(email, "49%")
                ,envolver(nombre, "99%")

                ,envolver(password, "25%")
                ,envolver(passwordConfirm, "25%")

                ,envolver(role, "99%")


//                 envolver(roles, "100%")

        );
    }

    @Override
    public void bindFormFields(BeanValidationBinder<Usuario> binder) {

        passwordBinding = binder.forField(password).withValidator(passwordValidator).bind(b -> "", (b, value) -> {
            if (!value.isEmpty()) {
                AtomicReference<SimpleByteSource> sbs = new AtomicReference<>(
                        new SimpleByteSource(username.getValue().concat(Sistema.getSistema().getPreSalt())));
                String pass = new Sha256Hash(value, sbs.get(), 1024).toBase64();
                b.setPassword(pass);
            }
        });

        confirmPasswordBinding = binder.forField(passwordConfirm).withValidator(
                Validator.from(this::ValidarConfirmPassword, C.SYS_APP_CHANGEPASS_ERR_DISTPASS))
                                       .bind(b -> "", (usuario, pwd) -> { });
        binder.bindInstanceFields(this);

        password.addValueChangeListener(e -> confirmPasswordBinding.validate());
    }

    @Override
    public Focusable getPrimerElementoForm() {
        return username;
    }

//    public  void generateSaltedHash(String password, Usuario usuario) {
//        ByteSource saltByteSrc = getRng().nextBytes();
//        usuario.setSalt(saltByteSrc.toHex());
//        Hash hash = hashConfig.createHash(password, saltByteSrc);
//        usuario.setPassword(hash.toHex());
//    }
//
//    private RandomNumberGenerator getRng() {
//        if (rng == null) {
//            rng = new SecureRandomNumberGenerator();
//        }
//        return rng;
//    }
}

