package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;


public class ComisionistaInnerForm extends DefaultInnerDialog<Comisionista> {

    private TextField id;
    private TextField nombre;
    private TextField apellido;
    private TextField cuil;
    private TextField celular;
    private TextField telefono;
    private TextField domicilio;
    private TextField email;
    private TextField saldoInicial;

    public ComisionistaInnerForm(IPresentableForm<Comisionista> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("588px");
        setWidth("700px");

        id = textField("ID");
        id.setPreventInvalidInput(true);
        nombre = textField("Nombre");
        apellido = textField("Apellido");
        cuil = textField("Cuil");
        celular = textField("Celular");
        telefono = textField("Telefono");
        domicilio = textField("Domicilio");
        email = textField("Correo electronico");
        saldoInicial = textField("Saldo inicial");

        form.add(
                envolver(id, "30%"),

                envolver(nombre,"48%"),
                envolver(apellido,"48%"),

                envolver(cuil,"50%"),

                envolver(celular,"48%"),
                envolver(telefono,"48%"),

                envolver(domicilio,"100%"),

                envolver(email, "100%"),

                envolver(saldoInicial, "50%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() { return nombre; }

    @Override
    public void bindFormFields(BeanValidationBinder<Comisionista> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Comisionista::getId, null);

        binder.bindInstanceFields( this);
    }
}
