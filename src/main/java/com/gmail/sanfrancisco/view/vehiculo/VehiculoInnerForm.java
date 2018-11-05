package com.gmail.sanfrancisco.view.vehiculo;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.dataProvider.ParametroVarioDataProvider;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;


import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;


public class VehiculoInnerForm extends DefaultInnerDialog<Vehiculo> {
    private TextField id;
    private ComboBox tipoVehiculo;
    private TextField modelo;
    private TextField dominio;
    private ComboBox tipoCombustible;
    private ComboBox color;
    private TextField maxCabezas;
    private TextField tara;
    private TextField cargaMax;
    private TextField consumoCombustible;
    private TextField alto;
    private TextField largo;
    private TextField ancho;
    private TextField numeroMotor;
    private TextField numeroChasis;
    private ComboBox marca;
    private TextField anio;
    private ComboBox estadoVehiculo;
    private DatePicker fecha;


    public VehiculoInnerForm(IPresentableForm<Vehiculo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

//        setHeight("672px");
        setWidth("700px");

        id = textField("ID","20em");
        id.setPreventInvalidInput(true);

        tipoVehiculo = new ComboBox("Tipo vehiculo");
        tipoVehiculo.setWidth("100%");
        ParametroVarioDataProvider dpTipoVehiculo = getObject(ParametroVarioDataProvider.class);
        dpTipoVehiculo.setTipo(ETipoParametro.TIPO_VEHICULO);
        tipoVehiculo.setDataProvider(dpTipoVehiculo);

        modelo = textField("Modelo");
        dominio = textField("Dominio");

        tipoCombustible = new ComboBox("Tipo combustible");
        tipoCombustible.setWidth("100%");
        ParametroVarioDataProvider dpTipoCombustible = getObject(ParametroVarioDataProvider.class);
        dpTipoCombustible.setTipo(ETipoParametro.TIPO_COMBUSTIBLE);
        tipoCombustible.setDataProvider(dpTipoCombustible);

        color = new ComboBox("Color");
        color.setWidth("100%");
        ParametroVarioDataProvider dpColor = getObject(ParametroVarioDataProvider.class);
        dpColor.setTipo(ETipoParametro.COLOR);
        color.setDataProvider(dpColor);


        maxCabezas = textField("Maximo de cabezas");
        tara = textField("Tara");
        cargaMax = textField("Carga maxima");
        consumoCombustible = textField("Consumo");
        alto = textField("Alto");
        largo = textField("Largo");
        ancho = textField("Ancho");
        numeroMotor = textField("Numero de motor");
        numeroChasis = textField("Numero de chasis");

        marca = new ComboBox("Marca");
        marca.setWidth("100%");
        ParametroVarioDataProvider dpMarca = getObject(ParametroVarioDataProvider.class);
        dpMarca.setTipo(ETipoParametro.MARCA_VEHICULO);
        marca.setDataProvider(dpMarca);

        anio = textField("Año");
        anio.setWidth("100%");
        anio.setRequired(true);

        estadoVehiculo = new ComboBox("Estado de vehiculo");
        estadoVehiculo.setWidth("100%");
        ParametroVarioDataProvider dpEstadoVehiculo = getObject(ParametroVarioDataProvider.class);
        dpEstadoVehiculo.setTipo(ETipoParametro.ESTADO_VEHICULO);
        estadoVehiculo.setDataProvider(dpEstadoVehiculo);

        fecha = dateField("Fecha de cambio de estado");
        fecha.setWidth("100%");
        fecha.setRequired(true);

        form.add(
                envolver(id, "75%"),
                envolver(dominio, "10%"),
                envolver(anio, "10%"),


                envolver(tipoVehiculo,     "30%"),
                envolver(marca, "32%"),
                envolver(modelo,        "35%"),


                envolver(numeroMotor,"40%"),
                envolver(numeroChasis,"40%"),
                envolver(color, "17%"),


                envolver(tara, "14%"),
                envolver(alto, "14%"),
                envolver(largo, "14%"),
                envolver(ancho, "14%"),
                envolver(maxCabezas,"14%"),
                envolver(cargaMax, "14%"),


                envolver(tipoCombustible, "48%"),
                envolver(consumoCombustible, "48%"),


                envolver(estadoVehiculo, "48%"),
                envolver(fecha, "48%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() { return dominio; }

    @Override
    public void bindFormFields(BeanValidationBinder<Vehiculo> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Vehiculo::getId, null);


        binder.forField(anio).withConverter(new IntegerConverter())
                .asRequired("Este dato es requerido")
                .bind("anio");
        anio.setPreventInvalidInput(true);


        binder.bind(tipoVehiculo,"tipoVehiculo");
        binder.bind(marca, "marca");


        binder.bind(color, "color");


        binder.forField(tara).withConverter(new DoubleConverter()).bind("tara");
        binder.forField(alto).withConverter(new DoubleConverter()).bind("alto");
        binder.forField(largo).withConverter(new DoubleConverter()).bind("largo");
        binder.forField(ancho).withConverter(new DoubleConverter()).bind("ancho");
        binder.forField(maxCabezas).withConverter(new IntegerConverter()).bind("maxCabezas");
        binder.forField(cargaMax).withConverter(new DoubleConverter()).bind("cargaMax");


        binder.bind(tipoCombustible, "tipoCombustible");
        binder.forField(consumoCombustible).withConverter(new DoubleConverter()).bind("consumoCombustible");


        binder.bind(estadoVehiculo, "estadoVehiculo");
        binder.forField(fecha)
                .withConverter(new LocalDateADateConverter())
                .bind(Vehiculo::getFecha, Vehiculo::setFecha);


        binder.bindInstanceFields(this);
    }
}
