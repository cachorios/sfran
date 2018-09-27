package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;


import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConductorInnerForm extends DefaultInnerDialog<Conductor> {

    private TextField id;
    private TextField apellido;
    private TextField nombre;
    private TextField dni;
    private TextField cuil;
    private DatePicker fechaNacimiento;
    private TextField telefono;
    private TextField celular;
    private TextField operadoraTelefonica;
    private DatePicker fechaIngreso;



    public ConductorInnerForm(IPresentableForm<Conductor> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected Component generarForm() {

        id = textField("ID");
        id.setPreventInvalidInput(true);
        apellido = textField("Apellido");
        nombre = textField("Nombre");
        dni = textField("DNI");
        cuil = textField("CUIL");

        fechaNacimiento = new DatePicker("Fecha Nacimiento");
        fechaNacimiento.setWidth("100%");
        fechaNacimiento.setRequired(true);

        telefono = textField("Nro. Telefono");
        celular = textField("Nro. Celular");
        operadoraTelefonica = textField("Operadora");

        fechaIngreso = new DatePicker("Fecha Ingreso");
        fechaIngreso.setWidth("100%");
        fechaIngreso.setRequired(true);

        Div form = new Div();
        form.setSizeFull();
        form.add(
                envolver(id, "30%"),
                envolver(apellido),
                envolver(nombre),
                envolver(dni,"50%"),
                envolver(cuil, "50%"),

                envolver(fechaNacimiento,"100%"),
                envolver(fechaIngreso,"100%"),

                envolver(telefono),
                envolver(celular,"50%"),
                envolver(operadoraTelefonica,"50%")

        );


        return form;
    }

    @Override
    public Focusable getPrimerElementoForm() {
        return apellido;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<Conductor> binder) {


        binder.forField(id)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Conductor::getId, null);

        binder.forField(fechaNacimiento)
                .withConverter(new LocalDateADateConverter())
                .bind(Conductor::getFechaNacimiento, Conductor::setFechaNacimiento);

        binder.forField(fechaIngreso)
                .withConverter(new LocalDateADateConverter())
                .bind(Conductor::getFechaIngreso, Conductor::setFechaIngreso);

        binder.forField(operadoraTelefonica)
                .withConverter(new StringToLongConverter("No es un nro válido."))
                .bind(Conductor::getOperadoraTelefonica, Conductor::setOperadoraTelefonica);

        binder.bindInstanceFields(this);
    }
}
