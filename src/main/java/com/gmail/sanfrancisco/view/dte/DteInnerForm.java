package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.backend.views.csselect.LocalidadCS;
import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.customs.params.ParamCSDataProvider;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.dataProvider.ParametroVarioDataProvider;
import com.gmail.sanfrancisco.dataProvider.VehiculolDataProvider;
import com.gmail.sanfrancisco.entidad.*;
import com.gmail.sanfrancisco.view.comisionista.ComisionistaCS;
import com.gmail.sanfrancisco.view.conductor.ConductorCS;
import com.gmail.sanfrancisco.view.consignatario.ConsignatarioCS;
import com.gmail.sanfrancisco.view.dtedetallecategoria.DteDetalleCategoriaForm;
import com.gmail.sanfrancisco.view.dtedetalleimpuesto.DteDetalleImpuestoForm;
import com.gmail.sanfrancisco.view.dtedetalleinsumo.DteDetalleInsumoForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;

import com.vaadin.flow.component.combobox.ComboBox;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;


import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import org.vaadin.tabs.PagedTabs;

import javax.enterprise.inject.spi.CDI;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
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

    private Grid<DteDetalleCategoria> categoriaGrid;
    private UnoaMuchoGrid<Dte, DteDetalleCategoria> categorias;

    private Grid<DteDetalleCategoria> insumoGrid;
    private UnoaMuchoGrid<Dte, DteDetalleInsumo> insumos;

    private Grid<DteDetalleImpuesto> impuestoGrid;
    private UnoaMuchoGrid<Dte, DteDetalleImpuesto> impuestos;

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

        PagedTabs tabs = new PagedTabs();
        tabs.setWidth("100%");
        tabs.add(getCategorias(), "Categorias");
        tabs.add(getInsumos(), "Insumos");
        tabs.add(getImpuestos(), "Impuestos");




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
                envolver(tabs)
//                envolver(getCategorias()),
//                envolver(getInsumos()),
//                envolver(getImpuestos())

        );

//        form.add(envolver(dteDetalleCategoriaList.getViewComponent()));
    }


    private Component getCategorias() {
        categorias = new UnoaMuchoGrid<>("", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getCategorias());

        categorias.getGrid().addColumn(DteDetalleCategoria::getProductor)
                .setHeader("Prodcutor")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("productor");

        categorias.getGrid().addColumn(DteDetalleCategoria::getRenspa)
                .setHeader("RENSPA")
                .setWidth("12%")
                .setKey("renspa");
        categorias.getGrid().addColumn(DteDetalleCategoria::getCategoria)
                .setHeader("Categoria")
                .setWidth("10%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getCantidad)
                .setHeader("Cantidad")
                .setWidth("6%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getKgVivo)
                .setHeader("Kg Vivo")
                .setWidth("6%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getPrecioKgVivo)
                .setHeader("Precio Kg Vivo")
                .setWidth("10%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getKgCarne)
                .setHeader("Kg Carne")
                .setWidth("7%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getPorcentajeComision)
                .setHeader("Porcentaje comision")
                .setWidth("11%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getSaldoComision)
                .setHeader("Saldo comision")
                .setWidth("9%");
        categorias.getGrid().addColumn(DteDetalleCategoria::getImporte)
                .setHeader("Importe")
                .setWidth("6%");

        categorias
            .withForm(DteDetalleCategoriaForm.class)
            .withVer()
            .withNuevo(DteDetalleCategoria.class)
            .withEditar()
            .withBorrar()
        ;
        categorias.getGrid().setHeight("9rem");

        return categorias.iniciar();
    }

    private Component getInsumos() {
        insumos = new UnoaMuchoGrid<>("", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getInsumos());

        insumos.getGrid().addColumn(DteDetalleInsumo::getInsumo)
                .setHeader("Insumo")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("insumo");

        insumos.getGrid().addColumn(DteDetalleInsumo::getPrecio)
                .setHeader("Precio")
                .setWidth("12%")
                .setKey("precio");
        insumos.getGrid().addColumn(DteDetalleInsumo::getCantidad)
                .setHeader("Cantidad")
                .setWidth("10%");
        insumos.getGrid().addColumn(DteDetalleInsumo::getImporte)
                .setHeader("Importe")
                .setWidth("6%");

        insumos
                .withForm(DteDetalleInsumoForm.class)
                .withVer()
                .withNuevo(DteDetalleInsumo.class)
                .withEditar()
                .withBorrar()
        ;
        insumos.getGrid().setHeight("9rem");
        return insumos.iniciar();
    }

    private Component getImpuestos() {
        impuestos = new UnoaMuchoGrid<>("", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getImpuestos());

        impuestos.getGrid().addColumn(DteDetalleImpuesto::getImpuesto)
                .setHeader("Impuesto")
                .setWidth("50%")
                .setFlexGrow(1)
                .setKey("impuesto");

        impuestos.getGrid().addColumn(DteDetalleImpuesto::getSaldo)
                .setHeader("Saldo")
                .setWidth("50%")
                .setKey("saldo");


        impuestos
                .withForm(DteDetalleImpuestoForm.class)
                .withVer()
                .withNuevo(DteDetalleImpuesto.class)
                .withEditar()
                .withBorrar()
        ;
        impuestos.getGrid().setHeight("9rem");
        return impuestos.iniciar();
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

        binder.bind(pciaOrigen, "provinciaOrigen");
        binder.bind(localidadOrigen, "localidadOrigen");
        binder.bind(pciaDestino, "provinciaDestino");
        binder.bind(localidadDestino, "localidadDestino");


        binder.bind(conductorCS, "conductor");
        binder.bind(vehiculoComboBox, "vehiculo");


        binder.bind(comisionistaCS, "comisionista");
        binder.bind(consignatarioCS, "consignatario");

        //integer
        binder.forField(cantidad).withConverter(new IntegerConverter()).bind("cantidad");
        binder.bind(especie, "especie");
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