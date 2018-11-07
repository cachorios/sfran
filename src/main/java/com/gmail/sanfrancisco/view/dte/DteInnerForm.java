package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.backend.views.csselect.LocalidadCS;
import com.gmail.cacho.slapi.view.componentes.UnoAMuchoGrid;
import com.gmail.cacho.slapi.view.customs.params.ParamCSDataProvider;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.cacho.slapi.view.utils.ViewTools;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.dataProvider.ParametroVarioDataProvider;
import com.gmail.sanfrancisco.dataProvider.VehiculolDataProvider;
import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.gmail.sanfrancisco.view.comisionista.ComisionistaCS;
import com.gmail.sanfrancisco.view.conductor.ConductorCS;
import com.gmail.sanfrancisco.view.consignatario.ConsignatarioCS;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;

import com.vaadin.flow.component.combobox.ComboBox;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;


import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;

import javax.enterprise.inject.spi.CDI;

import java.util.List;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.generarTituloSeccion;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteInnerForm extends DefaultInnerDialog<Dte> {

    private TextField numeroTropa;
    private ComboBox<Parametro> pciaOrigen;
    private ComboBox<Parametro> pciaDestino;

    private LocalidadCS localidadOrigen;
    private LocalidadCS localidadDestino;

    private ConductorCS conductorCS;
    private ComboBox<Vehiculo> vehiculoComboBox;
    private TextField patenteJaula;


    private TextField titular;

    private ComisionistaCS comisionistaCS;
    private ConsignatarioCS consignatarioCS;

    private TextField cantidad;
    private ComboBox especie;
    private TextField peso;


    private TextField kmSalida;
    private TextField kmLlegada;

    private DatePicker fechaCarga;
    private DatePicker fechaVencimiento;

    private TextField entrega;
    private TextField totalComisionista;
    private TextField ajustes;



//    private DteDetalleCategoriaList dteDetalleCategoriaList;
    private Grid<DteDetalleCategoria> categoriaGrid;
    private UnoAMuchoGrid<DteDetalleCategoria> categorias;

//    private VerticalLayout detalle;
//    private Button btnAdd;

    public DteInnerForm(IPresentableForm<Dte> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {
        setWidth("900px");

        numeroTropa = textField("Numero de tropa","30%");

        ParametroVarioDataProvider dpPcia = getObject(ParametroVarioDataProvider.class);
        dpPcia.setTipo(ETipoParametro.PROVINCIA);

        pciaOrigen = new ComboBox("Provincia Origen");
        pciaOrigen.setDataProvider(dpPcia);
        pciaOrigen.addValueChangeListener(e-> {this.pciaChanged(e, localidadOrigen);});
        localidadOrigen = new LocalidadCS("Localidad origen", getPresentable());

        pciaDestino = new ComboBox("Provincia Destino");
        pciaDestino.setDataProvider(dpPcia);
        pciaDestino.addValueChangeListener(e-> {this.pciaChanged(e, localidadDestino);});
        localidadDestino = new LocalidadCS("Localidad destino", getPresentable());


        conductorCS = new ConductorCS("Conductor", getPresentable(), true, true, true);

        vehiculoComboBox = new ComboBox<>("Vehiculo");
        vehiculoComboBox.setDataProvider(CDI.current().select(VehiculolDataProvider.class).get() );

        patenteJaula = textField("Patente de jaula");


        titular = textField("Titular");


        comisionistaCS = new ComisionistaCS("Comisionista", getPresentable(),true,true, true);
        consignatarioCS = new ConsignatarioCS("Consignatario", getPresentable(),true,true, true);


        cantidad = textField("Cantidad");
        especie = new ComboBox("Especie");
        especie.setWidth("100%");
        ParametroVarioDataProvider dpEspecie = getObject(ParametroVarioDataProvider.class);
        dpEspecie.setTipo(ETipoParametro.ESPECIES);
        especie.setDataProvider(dpEspecie);
        peso = textField("Peso");


        kmSalida = textField("Kilometros salida");
        kmLlegada = textField("Kilometros llegada");


        fechaCarga = new DatePicker("Fecha de carga");
        fechaCarga.setWidth("48%");
        fechaCarga.setRequired(true);

        fechaVencimiento = new DatePicker("Fecha de vencimiento");
        fechaVencimiento.setWidth("48%");
        fechaVencimiento.setRequired(true);


        entrega = textField("Entrega en efectivo");
        totalComisionista = textField("Total de comisionista");
        ajustes = textField("Ajustes");

//        dteDetalleCategoriaList = CDI.current().select(DteDetalleCategoriaList.class).get();
//        dteDetalleCategoriaList.iniciar(EModoVista.EDITAR, null);


//        btnAdd = new Button(VaadinIcon.PLUS.create());
//        btnAdd.addClickListener(e->{
//            detalle.add(new DteDetalle());
//        });
////
//        detalle.add(btnAdd,new DteDetalle());

        form.add(
                envolver(numeroTropa, "100%"),

                //generarTituloSeccion("Origen"),
                envolver(pciaOrigen, "18%"),
                envolver(localidadOrigen, "32%"),

                //generarTituloSeccion("Destino"),
                envolver(pciaDestino, "18%"),
                envolver(localidadDestino, "32%"),

                envolver(conductorCS, "56%"),
                envolver(vehiculoComboBox, "22%"),
                envolver(patenteJaula,"22%"),


                envolver(titular, "100%"),

                envolver(comisionistaCS,"56%"),
                envolver(consignatarioCS,"44%"),

                envolver(cantidad, "32%"),
                envolver(especie, "32%"),
                envolver(peso, "32%"),

                envolver(kmSalida,"48%"),
                envolver(kmLlegada,"48%"),

                envolver(fechaCarga,"48%"),
                envolver(fechaVencimiento,"48%"),

                envolver(entrega,"32%"),
                envolver(totalComisionista,"32%"),
                envolver(ajustes,"32%"),
                getCategorias()

        );

//        form.add(envolver(dteDetalleCategoriaList.getViewComponent()));
    }

    private Component getCategorias() {
        categorias = new UnoAMuchoGrid<>("Categorias", this.getPresentable().getObjetoActivo().getCategorias());

        categorias.getGrid().addColumn(DteDetalleCategoria::getProductor)
                .setHeader("Prodcutor")
                .setWidth("22%")
                .setFlexGrow(1)
                .setKey("productor");

        categorias.getGrid().addColumn(DteDetalleCategoria::getRenspa)
                .setHeader("RENSPA")
                .setWidth("12%")
                .setKey("renspa");
        categorias.getGrid().addColumn(DteDetalleCategoria::getCategoria)
                .setHeader("Categoria")
                .setWidth("14%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getCantidad)
                .setHeader("Cantidad")
                .setWidth("8%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getKgVivo)
                .setHeader("Kg Vivo")
                .setWidth("12%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getPrecioKgVivo)
                .setHeader("Precio Kg Vivo")
                .setWidth("8%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getKgCarne)
                .setHeader("Kg Carne")
                .setWidth("12%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getPorcentajeComision)
                .setHeader("Porcentaje comision")
                .setWidth("12%");

        categorias.getGrid().setHeight("10rem");
        return categorias.iniciar();
    }


    private void pciaChanged(HasValue.ValueChangeEvent<?> e, LocalidadCS localidadCS) {
        if( e.getValue() != null) {
            Long grupo = ((Parametro) e.getValue()).getId();                    //getOrden().longValue();
            ((ParamCSDataProvider) localidadCS.getDataProvider()).setGrupo(grupo);
        }else{
            ((ParamCSDataProvider)localidadCS.getDataProvider()).setGrupo( null );
        }
    }

    @Override
    public Focusable getPrimerElementoForm() {
        return numeroTropa;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<Dte> binder) {

        binder.bind(pciaOrigen, Dte::getProvinciaOrigen, Dte::setProvinciaOrigen);
        binder.bind(localidadOrigen, Dte::getLocalidadOrigen, Dte::setLocalidadOrigen);
        binder.bind(pciaDestino, Dte::getProvinciaDestino, Dte::setProvinciaDestino);
        binder.bind(localidadDestino, Dte::getLocalidadDestino, Dte::setLocalidadDestino);


        binder.bind(vehiculoComboBox, Dte::getVehiculo, Dte::setVehiculo);

        //integer
        binder.forField(cantidad).withConverter(new IntegerConverter()).bind("cantidad");
        binder.bind(especie, Dte::getEspecie, Dte::setEspecie);
        binder.forField(peso).withConverter(new IntegerConverter()).bind("peso");


        binder.forField(kmSalida).withConverter(new DoubleConverter()).bind("kmSalida");
        binder.forField(kmLlegada).withConverter(new DoubleConverter()).bind("kmLlegada");


        binder.forField(fechaCarga)
                .withConverter(new LocalDateADateConverter())
                .bind("fechaCarga");

        binder.forField(fechaVencimiento)
                .withConverter(new LocalDateADateConverter())
                .bind("fechaVencimiento");


        binder.forField(entrega).withConverter(new DoubleConverter()).bind("importeEntrega");
        binder.forField(totalComisionista).withConverter(new DoubleConverter()).bind("totalComisionista");
        binder.forField(ajustes).withConverter(new DoubleConverter()).bind("ajustes");

        binder.bindInstanceFields(this);
    }


}