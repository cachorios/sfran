package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.views.csselect.LocalidadCS;
import com.gmail.cacho.slapi.view.customs.params.ParamCSDataProvider;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.dataProvider.ParametroVarioDataProvider;
import com.gmail.sanfrancisco.dataProvider.VehiculolDataProvider;
import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.gmail.sanfrancisco.view.comisionista.ComisionistaCS;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToIntegerConverter;

import javax.enterprise.inject.spi.CDI;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.generarTituloSeccion;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteInnerForm extends DefaultInnerDialog<Dte> {

    private TextField numeroTropa;
    private ComboBox<Parametro> pciaOrigen;
    private ComboBox<Parametro> pciaDestino;

    private LocalidadCS localidadOrigen;
    private LocalidadCS localidadDestino;

    private ComboBox<Vehiculo> vehiculoComboBox;
    private TextField titular;

    private ComisionistaCS comisionistaCS;

    private TextField cantidad;
    private ComboBox especie;
    private TextField peso;


//    private TextField entrega;

    /*private TextField total;
    private TextField ajustes;

    private DatePicker fechaCarga;
    private DatePicker fechaVencimiento;
    private TextField kmSalida;
    private TextField kmLlegada;
    private TextField patenteJaula; */


    public DteInnerForm(IPresentableForm<Dte> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }



    @Override
    protected void generarForm(Div form) {

//        setHeight("672px");
        setWidth("800px");

        numeroTropa = textField("Numero de tropa","30%");

        ParametroVarioDataProvider dpPcia= getObject(ParametroVarioDataProvider.class);
        dpPcia.setTipo(ETipoParametro.PROVINCIA);

        pciaOrigen = new ComboBox("Provincia");
        pciaOrigen.setDataProvider(dpPcia);
        pciaOrigen.addValueChangeListener(e-> {this.pciaChanged(e, localidadOrigen);});
        localidadOrigen = new LocalidadCS("Localidad", getPresentable());

        pciaDestino = new ComboBox("Provincia");
        pciaDestino.setDataProvider(dpPcia);
        pciaDestino.addValueChangeListener(e-> {this.pciaChanged(e, localidadDestino);});
        localidadDestino = new LocalidadCS("Localidad", getPresentable());

        vehiculoComboBox = new ComboBox<>("Vehiculo");
        vehiculoComboBox.setDataProvider(CDI.current().select(VehiculolDataProvider.class).get() );
        titular = textField("Titular");

        comisionistaCS = new ComisionistaCS("Comisionista", getPresentable(),true,true, true);

        especie = new ComboBox("Especie");
        especie.setWidth("100%");
        ParametroVarioDataProvider dpEspecie = getObject(ParametroVarioDataProvider.class);
        dpEspecie.setTipo(ETipoParametro.ESPECIES);
        especie.setDataProvider(dpEspecie);

        cantidad = textField("Cantidad");
        peso = textField("Peso");






     /*   entrega = textField("Entrega en efectivo");
        total = textField("Total de factura");
        ajustes = textField("Ajustes");

        fechaCarga = new DatePicker("Fecha de carga");
        fechaCarga.setWidth("100%");
        fechaCarga.setRequired(true);

        fechaVencimiento = new DatePicker("Fecha de vencimiento");
        fechaVencimiento.setWidth("100%");
        fechaVencimiento.setRequired(true);

        kmSalida = textField("Kilometros de salida");
        kmLlegada = textField("Kilometros de llegada");
        patenteJaula = textField("Patente de jaula");
        titular = textField("Titular");*/

        form.add(
                envolver(numeroTropa, "100%"),

                generarTituloSeccion("Origen"),
                envolver(pciaOrigen, "40%"),
                envolver(localidadOrigen, "58%"),

                generarTituloSeccion("Destino"),
                envolver(pciaDestino, "40%"),
                envolver(localidadDestino, "58%"),

                envolver(vehiculoComboBox, "49%"),
                envolver(titular, "49%"),

                envolver(comisionistaCS),

                envolver(cantidad, "32%"),
                envolver(especie, "32%"),
                envolver(peso, "32%")



           /*     envolver(entrega,"32%"),
                envolver(total,"32%"),
                envolver(ajustes,"32%"),


                envolver(fechaCarga,"48%"),
                envolver(fechaVencimiento,"48%"),

                envolver(kmSalida,"48"),
                envolver(kmLlegada,"48%"),

                envolver(patenteJaula,"48%"),
                envolver(titular,"48%")*/
        );

    }

    private void pciaChanged(HasValue.ValueChangeEvent<?> e, LocalidadCS localidadCS) {
        if( e.getValue() != null){
            Long grupo = ((Parametro) e.getValue()).getOrden().longValue();
            ((ParamCSDataProvider)localidadCS.getDataProvider()).setGrupo( grupo );
        }
    }

    @Override
    public Focusable getPrimerElementoForm() {
        return numeroTropa;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<Dte> binder) {

        binder.forField(cantidad)
                .withConverter(new StringToIntegerConverter("No es un nro válido."))
                .withNullRepresentation(0)
                .bind(Dte::getCantidad, Dte::setCantidad);

        binder.forField(peso)
                .withConverter(new StringToIntegerConverter( "No es un nro válido."))
                .withNullRepresentation(0)
                .bind(Dte::getPeso, Dte::setPeso);


        binder.bind(especie, Dte::getEspecie, Dte::setEspecie);

        binder.bind(pciaOrigen, Dte::getProvinciaOrigen, Dte::setProvinciaOrigen);
        binder.bind(localidadOrigen, Dte::getLocalidadOrigen, Dte::setLocalidadOrigen);

        binder.bind(pciaDestino, Dte::getProvinciaDestino, Dte::setProvinciaDestino);
        binder.bind(localidadDestino, Dte::getLocalidadDestino, Dte::setLocalidadDestino);

        binder.bind(vehiculoComboBox, Dte::getVehiculo, Dte::setVehiculo);





//        binder.forField(fechaCarga)
//                .withConverter(new LocalDateADateConverter())
//                .bind(Dte::getFechaCarga, Dte::setFechaCarga);
//
//        binder.forField(fechaVencimiento)
//                .withConverter(new LocalDateADateConverter())
//                .bind(Dte::getFechaVencimiento, Dte::setFechaVencimiento);

        binder.bindInstanceFields(this);
    }


}