package com.gmail.sanfrancisco.view.vehiculocosto;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.dataProvider.VehiculoDataProvider;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.gmail.sanfrancisco.entidad.VehiculoCosto;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumo;
import com.gmail.sanfrancisco.view.vehiculocostoinsumo.VehiculoCostoInsumoForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import javax.enterprise.inject.spi.CDI;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class VehiculoCostoInnerForm extends DefaultInnerDialog<VehiculoCosto> {

    private DatePicker fecha;

    private ComboBox<Vehiculo> vehiculoComboBox;

    private Grid<VehiculoCostoInsumo> insumoGrid;
    private UnoaMuchoGrid<VehiculoCosto, VehiculoCostoInsumo> insumos;

    public VehiculoCostoInnerForm(IPresentableForm<VehiculoCosto> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("312px");
        setWidth("700px");

        fecha = dateField("Fecha");
        fecha.setWidth("32%");
        fecha.setRequired(true);

        vehiculoComboBox = new ComboBox<>("Vehiculo");
        vehiculoComboBox.setDataProvider(CDI.current().select(VehiculoDataProvider.class).get() );

        form.add(

                envolver(fecha, "48%"),
                envolver(vehiculoComboBox, "30%"),
                envolver(getInsumos())
        );
    }

    private Component getInsumos() {
        insumos = new UnoaMuchoGrid<>("", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getInsumos(), this.getPresentable());

        insumos.getGrid().addColumn(VehiculoCostoInsumo::getInsumo)
                .setHeader("Insumo")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("insumo")
                .setFooter("Total");

        insumos.getGrid().addColumn(VehiculoCostoInsumo::getPrecio)
                .setHeader("Precio")
                .setWidth("12%")
                .setKey("precio");
        insumos.getGrid().addColumn(VehiculoCostoInsumo::getCantidad)
                .setHeader("Cantidad")
                .setWidth("10%");

        insumos
                .withForm(VehiculoCostoInsumoForm.class)
                .withVer()
                .withNuevo(VehiculoCostoInsumo.class)
                .withEditar()
                .withBorrar()
        ;
        insumos.getGrid().setHeight("11rem");
        return insumos.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() { return fecha; }

    @Override
    public void bindFormFields(BeanValidationBinder<VehiculoCosto> binder) {

        binder.forField(fecha)
                .withConverter(new LocalDateADateConverter())
                .bind(VehiculoCosto::getFecha, VehiculoCosto::setFecha);

        binder.bind(vehiculoComboBox, "vehiculo");

        binder.bindInstanceFields( this);
    }
}
