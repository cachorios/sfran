package com.gmail.sanfrancisco.view.vehiculo;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
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
                envolver(id),

                envolver(tipoVehiculo,     "32%"),
                envolver(modelo,        "32%"),
                envolver(dominio,       "32%"),

                envolver(tara, "48%"),
                envolver(maxCabezas,"48%"),

                envolver(cargaMax, "32%"),
                envolver(tipoCombustible, "32%"),
                envolver(consumoCombustible, "32%"),

                envolver(alto, "32%"),
                envolver(largo, "32%"),
                envolver(ancho, "32%"),

                envolver(numeroMotor,"48%"),
                envolver(numeroChasis,"48%"),

                envolver(color, "32%"),
                envolver(marca, "32%"),
                envolver(anio, "32%"),

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

        binder.bind(tipoVehiculo, Vehiculo::getTipoVehiculo, Vehiculo::setTipoVehiculo);

        binder.bind(tipoCombustible, Vehiculo::getTipoCombustible, Vehiculo::setTipoCombustible);

        binder.bind(color, Vehiculo::getColor, Vehiculo::setColor);

        binder.forField(maxCabezas)
                .withConverter(new StringToIntegerConverter( "No es un nro válido."))
                .withNullRepresentation(0)
                .bind(Vehiculo::getMaxCabezas, Vehiculo::setMaxCabezas);

        binder.forField(tara)
                .withConverter(new StringToDoubleConverter( "No es un nro válido."))
                .withNullRepresentation(0.0)
                .bind(Vehiculo::getTara, Vehiculo::setTara);

        binder.forField(cargaMax)
                .withConverter(new StringToDoubleConverter( "No es un nro válido."))
                .withNullRepresentation(0.0)
                .bind(Vehiculo::getCargaMax, Vehiculo::setCargaMax);

        binder.forField(consumoCombustible)
                .withConverter(new StringToDoubleConverter( "No es un nro válido."))
                .withNullRepresentation(0.0)
                .bind(Vehiculo::getConsumoCombustible, Vehiculo::setConsumoCombustible);

        binder.forField(alto)
                .withConverter(new StringToDoubleConverter( "No es un nro válido."))
                .withNullRepresentation(0.0)
                .bind(Vehiculo::getAlto, Vehiculo::setAlto);

        binder.forField(largo)
                .withConverter(new StringToDoubleConverter( "No es un nro válido."))
                .withNullRepresentation(0.0)
                .bind(Vehiculo::getLargo, Vehiculo::setLargo);

        binder.forField(ancho)
                .withConverter(new StringToDoubleConverter( "No es un nro válido."))
                .withNullRepresentation(0.0)
                .bind(Vehiculo::getAncho, Vehiculo::setAncho);

        binder.bind(marca, Vehiculo::getMarca, Vehiculo::setMarca);

        binder.forField(anio)
                .withConverter(new StringToIntegerConverter( "No es un nro válido."))
                .withNullRepresentation(0)
                .bind(Vehiculo::getAnio, Vehiculo::setAnio);

        binder.bind(estadoVehiculo, Vehiculo::getEstadoVehiculo, Vehiculo::setEstadoVehiculo);

        binder.forField(fecha)
                .withConverter(new LocalDateADateConverter())
                .bind(Vehiculo::getFecha, Vehiculo::setFecha);

        binder.bindInstanceFields(this);
    }
}
