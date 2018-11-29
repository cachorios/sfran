package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.LongConverter;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;


public class ComisionistaInnerForm extends DefaultInnerDialog<Comisionista> {

    private TextField id;
    private TextField nombre;
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

//        setHeight("588px");
        setWidth("700px");

        id = textField("ID","20em");
        id.setPreventInvalidInput(true);
        nombre = textField("Rázon social");
        cuil = textField("Cuil");
        celular = textField("Celular");
        telefono = textField("Telefono");
        domicilio = textField("Domicilio");
        email = textField("Correo electronico");
        saldoInicial = textField("Saldo inicial");

        form.add(
                envolver(id),

                envolver(nombre, "48%"),

                envolver(cuil, "48%"),

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
                .withConverter(new LongConverter())
                .bind(Comisionista::getId, null);

        binder.forField(saldoInicial).withConverter(new DoubleConverter()).bind("saldoInicial");


        binder.bindInstanceFields( this);
    }
}
