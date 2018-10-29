package com.gmail.sanfrancisco.view.consignatario;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.espacio;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConsignatarioInnerForm extends DefaultInnerDialog<Consignatario> {

    private TextField id;
    private TextField nombre;
    private TextField cuil;
    private TextField celular;
    private TextField telefono;
    private TextField domicilio;
    private TextField email;

    public ConsignatarioInnerForm(IPresentableForm<Consignatario> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

//        setHeight("504px");
        setWidth("700px");

        id = textField("ID","20em");
        id.setPreventInvalidInput(true);
        nombre = textField("Rázon social");
        cuil = textField("Cuil");
        celular = textField("Celular");
        telefono = textField("Telefono");
        domicilio = textField("Domicilio");
        email = textField("Correo electronico");

        form.add(
                envolver(id),
                envolver(nombre),

                envolver(cuil,"50%"),

                envolver(celular,"48%"),
                envolver(telefono,"48%"),

                envolver(domicilio,"100%"),

                envolver(email, "100%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() { return nombre; }

    @Override
    public void bindFormFields(BeanValidationBinder<Consignatario> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Consignatario::getId, null);

        binder.bindInstanceFields( this);
    }
}

