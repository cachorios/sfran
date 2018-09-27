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
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConsignatarioInnerForm extends DefaultInnerDialog<Consignatario> {

    private TextField id;
    private TextField descripcion;
    private TextField cuil;
    private TextField celular;
    private TextField telefono;
    private TextField domicilio;
    private TextField email;
    private TextField saldo;
    private TextField saldoInicial;

    public ConsignatarioInnerForm(IPresentableForm<Consignatario> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected Component generarForm() {

        id = textField("ID");
        id.setPreventInvalidInput(true);
        descripcion = textField("Descripción");
        cuil = textField("Cuil");
        celular = textField("Celular");
        telefono = textField("Telefono");
        domicilio = textField("Domicilio");
        email = textField("Correo electronico");

        Div form = new Div();
        form.setSizeFull();
        form.add(
                envolver(id, "30%"),
                envolver(descripcion,"50%"),
                envolver(cuil,"50%"),
                envolver(celular,"50%"),
                envolver(telefono,"50%"),
                envolver(domicilio,"100%"),
                envolver(email, "100%"),
                envolver(saldo, "50%"),
                envolver(saldoInicial, "50%")
        );

        return form;
    }

    @Override
    public Focusable getPrimerElementoForm() { return descripcion; }

    @Override
    public void bindFormFields(BeanValidationBinder<Consignatario> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Consignatario::getId, null);

        binder.bindInstanceFields( this);
    }
}

