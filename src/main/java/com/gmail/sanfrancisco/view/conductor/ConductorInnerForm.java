package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.dataProvider.ParametroVarioDataProvider;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.component.Focusable;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;


import javax.enterprise.inject.spi.CDI;

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
    private ComboBox operadoraTelefonica;
    private DatePicker fechaIngreso;



    public ConductorInnerForm(IPresentableForm<Conductor> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

//        setHeight("420px");
        setWidth("700px");

        id = textField("ID","20em");
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

        operadoraTelefonica = new ComboBox("Operadora");
        operadoraTelefonica.setWidth("100%");
        ParametroVarioDataProvider dp = CDI.current().select(ParametroVarioDataProvider.class).get();
        dp.setTipo(ETipoParametro.OPERADORA_TEL);
        operadoraTelefonica.setDataProvider(dp);

        fechaIngreso = new DatePicker("Fecha Ingreso");
        fechaIngreso.setWidth("100%");
        fechaIngreso.setRequired(true);

        form.add(
                envolver(id),

                envolver(apellido, "48%"),
                envolver(nombre, "48%"),

                envolver(dni,"48%"),
                envolver(cuil, "48%"),

                envolver(fechaNacimiento,"48%"),
                envolver(fechaIngreso,"48%"),

                envolver(telefono,"28%"),
                envolver(celular,"28%"),
                envolver(operadoraTelefonica,"40%")

        );

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

        binder.bind(operadoraTelefonica, conductor -> conductor.getOperadoraTelefonica(), (conductor, parametro) -> conductor.setOperadoraTelefonica(parametro));


        binder.bindInstanceFields(this);
    }
}
