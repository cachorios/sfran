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
    protected Component generarForm() {

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

        Div form = new Div();
        form.setSizeFull();
        form.add(
                envolver(id, "30%"),
                envolver(origen,"50%"),
                envolver(destino, "50%"),
                envolver(cantidad,"50%"),
                envolver(especie, "50%"),
                envolver(peso,"50%"),
                envolver(entrega,"50%"),
                envolver(total,"50%"),
                envolver(ajustes,"50%"),
                envolver(numeroTropa,"50%"),
                envolver(fechaCarga,"50%"),
                envolver(fechaVencimiento,"50%"),
                envolver(kmSalida,"50%"),
                envolver(kmLlegada,"50%"),
                envolver(patenteJaula,"50%"),
                envolver(titular,"50%")
        );

        return form;
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