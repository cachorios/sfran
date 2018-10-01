package com.gmail.sanfrancisco.view.productor;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.gmail.sanfrancisco.entidad.Productor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ProductorInnerForm extends DefaultInnerDialog<Productor> {

    private TextField id;
    private TextField nombre;
    private TextField apellido;
    private TextField cuil;
    private TextField celular;
    private TextField telefono;
    private TextField domicilio;
    private TextField email;

    public ProductorInnerForm(IPresentableForm<Productor> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected Component generarForm() {

        id = textField("ID");
        id.setPreventInvalidInput(true);
        nombre = textField("Nombre");
        apellido = textField("Apellido");
        cuil = textField("Cuil");
        celular = textField("Celular");
        telefono = textField("Telefono");
        domicilio = textField("Domicilio");
        email = textField("Correo electronico");

        Div form = new Div();
        form.setSizeFull();
        form.add(
                envolver(id, "30%"),
                envolver(nombre,"50%"),
                envolver(apellido,"50%"),
                envolver(cuil,"50%"),
                envolver(celular,"50%"),
                envolver(telefono,"50%"),
                envolver(domicilio,"100%"),
                envolver(email, "100%")
        );

        return form;
    }

    @Override
    public Focusable getPrimerElementoForm() { return nombre; }

    @Override
    public void bindFormFields(BeanValidationBinder<Productor> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Productor::getId, null);

        binder.bindInstanceFields( this);
    }
}