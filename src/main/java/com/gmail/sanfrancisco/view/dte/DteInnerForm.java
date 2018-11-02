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
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.gmail.sanfrancisco.view.comisionista.ComisionistaCS;
import com.gmail.sanfrancisco.view.conductor.ConductorCS;
import com.gmail.sanfrancisco.view.consignatario.ConsignatarioCS;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;

import com.vaadin.flow.component.combobox.ComboBox;

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

    private ComboBox<Vehiculo> vehiculoComboBox;
    private ConductorCS conductorCS;

    private TextField titular;

    private ComisionistaCS comisionistaCS;

    private ConsignatarioCS consignatarioCS;

    private TextField cantidad;
    private ComboBox especie;
    private TextField peso;


    private TextField kmSalida;
    private TextField kmLlegada;

//    private DatePicker fechaCarga;
//    private DatePicker fechaVencimiento;




//    private TextField entrega;

    /*private TextField totalComisionista;
    private TextField ajustes;



    private TextField patenteJaula; */

//    private DteDetalleCategoriaList dteDetalleCategoriaList;
    private Grid<DteDetalleCategoria> categoriaGrid;

//    private VerticalLayout detalle;
//    private Button btnAdd;

    public DteInnerForm(IPresentableForm<Dte> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {
        setWidth("1100px");

        numeroTropa = textField("Numero de tropa","30%");

        ParametroVarioDataProvider dpPcia= getObject(ParametroVarioDataProvider.class);
        dpPcia.setTipo(ETipoParametro.PROVINCIA);

        pciaOrigen = new ComboBox("Provincia Origen");
        pciaOrigen.setDataProvider(dpPcia);
        pciaOrigen.addValueChangeListener(e-> {this.pciaChanged(e, localidadOrigen);});
        localidadOrigen = new LocalidadCS("Localidad", getPresentable());

        pciaDestino = new ComboBox("Provincia Destino");
        pciaDestino.setDataProvider(dpPcia);
        pciaDestino.addValueChangeListener(e-> {this.pciaChanged(e, localidadDestino);});
        localidadDestino = new LocalidadCS("Localidad", getPresentable());

        vehiculoComboBox = new ComboBox<>("Vehiculo");
        vehiculoComboBox.setDataProvider(CDI.current().select(VehiculolDataProvider.class).get() );
        conductorCS = new ConductorCS("Conductor", getPresentable(), true, true, true);



        titular = textField("Titular");

        comisionistaCS = new ComisionistaCS("Comisionista", getPresentable(),true,true, true);


        especie = new ComboBox("Especie");
        especie.setWidth("100%");
        ParametroVarioDataProvider dpEspecie = getObject(ParametroVarioDataProvider.class);
        dpEspecie.setTipo(ETipoParametro.ESPECIES);
        especie.setDataProvider(dpEspecie);

        cantidad = textField("Cantidad");
        peso = textField("Peso");


        kmSalida = textField("Kilometros salida");
        kmLlegada = textField("Kilometros llegada");

//        dteDetalleCategoriaList = CDI.current().select(DteDetalleCategoriaList.class).get();
//        dteDetalleCategoriaList.iniciar(EModoVista.EDITAR, null);


//        btnAdd = new Button(VaadinIcon.PLUS.create());
//        btnAdd.addClickListener(e->{
//            detalle.add(new DteDetalle());
//        });
////
//        detalle.add(btnAdd,new DteDetalle());

     /*   entrega = textField("Entrega en efectivo");
        totalComisionista = textField("Total a comisionista");
        ajustes = textField("Ajustes");


        fechaCarga = new DatePicker("Fecha de carga");
        fechaCarga.setWidth("100%");
        fechaCarga.setRequired(true);

        fechaVencimiento = new DatePicker("Fecha de vencimiento");
        fechaVencimiento.setWidth("100%");
        fechaVencimiento.setRequired(true);

        consignatarioCS = new ConsignatarioCS("Consignatario", getPresentable(),true,true, true);

     /*   entrega = textField("Entrega en efectivo");
        total = textField("Total de factura");
        ajustes = textField("Ajustes");


        ;





        patenteJaula = textField("Patente de jaula");

        */





        consignatarioCS = new ConsignatarioCS("Consignatario", getPresentable(),true,true, true);
        form.add(
                envolver(numeroTropa, "100%"),

                //generarTituloSeccion("Origen"),
                envolver(pciaOrigen, "20%"),
                envolver(localidadOrigen, "29%"),

                //generarTituloSeccion("Destino"),
                envolver(pciaDestino, "20%"),
                envolver(localidadDestino, "29%"),

                envolver(vehiculoComboBox, "20%"),
                envolver(conductorCS, "29%"),

                envolver(titular, "49%"),

                envolver(comisionistaCS,"49%"),
                envolver(consignatarioCS,"49%"),

                envolver(cantidad, "32%"),
                envolver(especie, "32%"),
                envolver(peso, "32%"),

                envolver(kmSalida,"48%"),
                envolver(kmLlegada,"48%")
//
//                envolver(fechaCarga,"48%"),
//                envolver(fechaVencimiento,"48%"),

           /*     envolver(entrega,"32%"),
                envolver(totalComisionista,"32%"),
                envolver(ajustes,"32%"),


                envolver(patenteJaula,"48%"),
                envolver(titular,"48%")*/
            , getCategoriaGrid()

        );

//        form.add(envolver(dteDetalleCategoriaList.getViewComponent()));
    }

    private Grid getCategoriaGrid(){
        categoriaGrid = new Grid<>();
        categoriaGrid.addColumn(DteDetalleCategoria::getProductor)
                .setHeader("Prodcutor")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("productor");

        categoriaGrid.addColumn(DteDetalleCategoria::getRenspa)
                .setHeader("RENSPA")
                .setWidth("8%")
                .setKey("renspa");
        categoriaGrid.addColumn(DteDetalleCategoria::getCategoria)
                .setHeader("Categoria")
                .setWidth("15%");

        categoriaGrid.addColumn(DteDetalleCategoria::getKgVivo)
                .setHeader("Kg Vivo")
                .setWidth("10%");

        List a = this.getPresentable().getObjetoActivo().getCategorias();
        categoriaGrid.setItems(this.getPresentable().getObjetoActivo().getCategorias());

        return categoriaGrid;


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
        //integer
        binder.forField(cantidad)
                .withConverter(new StringToIntegerConverter("No es un nro válido."))
                .withNullRepresentation(0)
                .bind(Dte::getCantidad, Dte::setCantidad);
        binder.forField(peso)
                .withConverter(new StringToIntegerConverter( "No es un nro válido."))
                .withNullRepresentation(0)
                .bind(Dte::getPeso, Dte::setPeso);



        //combos o multiples
        binder.bind(pciaOrigen, Dte::getProvinciaOrigen, Dte::setProvinciaOrigen);
        binder.bind(localidadOrigen, Dte::getLocalidadOrigen, Dte::setLocalidadOrigen);
        binder.bind(pciaDestino, Dte::getProvinciaDestino, Dte::setProvinciaDestino);
        binder.bind(localidadDestino, Dte::getLocalidadDestino, Dte::setLocalidadDestino);
        binder.bind(especie, Dte::getEspecie, Dte::setEspecie);
        binder.bind(vehiculoComboBox, Dte::getVehiculo, Dte::setVehiculo);

        binder.forField(kmSalida)
                .withConverter(new StringToDoubleConverter("No es un nro. válido" ))
                .withNullRepresentation(0.0)
                .bind( Dte::getKmSalida, Dte::setKmSalida);

        binder.forField(kmLlegada)
                .withConverter(new StringToDoubleConverter("No es un nro. válido" ))
                .withNullRepresentation(0.0)
                .bind( Dte::getKmSalida, Dte::setKmSalida);


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