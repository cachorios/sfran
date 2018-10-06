package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Dte;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteInnerForm extends DefaultInnerDialog<Dte> {

    private TextField id;
    private TextField origen;
    private TextField destino;
    private TextField cantidad;
    private TextField especie;
    private TextField peso;
    private TextField entrega;
    private TextField total;
    private TextField ajustes;
    private TextField numeroTropa;
    private DatePicker fechaCarga;
    private DatePicker fechaVencimiento;
    private TextField kmSalida;
    private TextField kmLlegada;
    private TextField patenteJaula;
    private TextField titular;

    public DteInnerForm(IPresentableForm<Dte> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("672px");
        setWidth("700px");

        id = textField("ID");
        id.setPreventInvalidInput(true);
        origen = textField("Origen");
        destino = textField("Destino");
        cantidad = textField("Cantidad");
        especie = textField("Especie");
        cantidad = textField("Cantidad");
        peso = textField("Peso");
        entrega = textField("Entrega en efectivo");
        total = textField("Total de factura");
        ajustes = textField("Ajustes");
        numeroTropa = textField("Numero de tropa");

        fechaCarga = new DatePicker("Fecha de carga");
        fechaCarga.setWidth("100%");
        fechaCarga.setRequired(true);

        fechaVencimiento = new DatePicker("Fecha de vencimiento");
        fechaVencimiento.setWidth("100%");
        fechaVencimiento.setRequired(true);

        kmSalida = textField("Kilometros de salida");
        kmLlegada = textField("Kilometros de llegada");
        patenteJaula = textField("Patente de jaula");
        titular = textField("Titular");

        form.add(
                envolver(id, "30%"),

                envolver(numeroTropa,"50%"),

                envolver(origen,"48%"),
                envolver(destino, "48%"),

                envolver(cantidad,"32%"),
                envolver(especie, "32%"),
                envolver(peso,"32%"),

                envolver(entrega,"32%"),
                envolver(total,"32%"),
                envolver(ajustes,"32%"),


                envolver(fechaCarga,"48%"),
                envolver(fechaVencimiento,"48%"),

                envolver(kmSalida,"48"),
                envolver(kmLlegada,"48%"),

                envolver(patenteJaula,"48%"),
                envolver(titular,"48%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() {
        return numeroTropa;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<Dte> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Dte::getId, null);

        binder.forField(origen)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Dte::getOrigen, null);

        binder.forField(destino)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Dte::getDestino, null);

        binder.forField(especie)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Dte::getEspecie, null);

        binder.forField(fechaCarga)
                .withConverter(new LocalDateADateConverter())
                .bind(Dte::getFechaCarga, Dte::setFechaCarga);

        binder.forField(fechaVencimiento)
                .withConverter(new LocalDateADateConverter())
                .bind(Dte::getFechaVencimiento, Dte::setFechaVencimiento);

        binder.bindInstanceFields(this);
    }
}