package com.gmail.sanfrancisco.view.movil;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Movil;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class MovilInnerForm extends DefaultInnerDialog<Movil> {
    private TextField id;
    private TextField tipoMovil;
    private TextField modelo;
    private TextField dominio;
    private TextField tipoCombustible;
    private TextField color;
    private TextField maxCabezas;
    private TextField tara;
    private TextField cargaMax;
    private TextField consumo;
    private TextField alto;
    private TextField largo;
    private TextField ancho;
    private TextField volumen;
    private TextField numeroMotor;
    private TextField numeroChasis;
    private TextField marca;
    private DatePicker anno;
    private TextField estadoMovil;
    private DatePicker fecha;

    public MovilInnerForm(IPresentableForm<Movil> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("672px");
        setWidth("700px");

        id = textField("ID");
        id.setPreventInvalidInput(true);
        tipoMovil = textField("Tipo de movil");
        modelo = textField("Modelo");
        dominio = textField("Dominio");
        tipoCombustible = textField("Tipo de combustible");
        color = textField("Color");
        maxCabezas = textField("Maximo de cabezas");
        tara = textField("Tara");
        cargaMax = textField("Carga maxima");
        consumo = textField("Consumo");
        alto = textField("Alto");
        largo = textField("Largo");
        ancho = textField("Ancho");
        numeroMotor = textField("Numero de motor");
        numeroChasis = textField("Numero de chasis");
        marca = textField("Marca");

        anno = dateField("Año");
        anno.setWidth("100%");
        anno.setRequired(true);

        estadoMovil = textField("Estado del movil");

        fecha = dateField("Fecha de cambio de estado");
        fecha.setWidth("100%");
        fecha.setRequired(true);

        form.add(
                envolver(id,            "30%"),

                envolver(tipoMovil,     "32%"),
                envolver(modelo,        "32%"),
                envolver(dominio,       "32%"),

                envolver(tara, "48%"),
                envolver(maxCabezas,"48%"),

                envolver(cargaMax, "32%"),
                envolver(tipoCombustible, "32%"),
                envolver(consumo, "32%"),

                envolver(alto, "32%"),
                envolver(largo, "32%"),
                envolver(ancho, "32%"),

                envolver(numeroMotor,"48%"),
                envolver(numeroChasis,"48%"),

                envolver(color, "32%"),
                envolver(marca, "32%"),
                envolver(anno, "32%"),

                envolver(estadoMovil, "48%"),
                envolver(fecha, "48%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() { return dominio; }

    @Override
    public void bindFormFields(BeanValidationBinder<Movil> binder) {
        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Movil::getId, null);

        binder.forField(tipoMovil)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Movil::getTipoMovil, null);

        binder.forField(tipoCombustible)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Movil::getTipoCombustible, null);

        binder.forField(marca)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Movil::getMarca, null);

        binder.forField(anno)
                .withConverter(new LocalDateADateConverter())
                .bind(Movil::getAnno, Movil::setAnno);

        binder.forField(estadoMovil)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Movil::getEstadoMovil, null);

        binder.forField(fecha)
                .withConverter(new LocalDateADateConverter())
                .bind(Movil::getFecha, Movil::setFecha);

        binder.bindInstanceFields(this);
    }
}
