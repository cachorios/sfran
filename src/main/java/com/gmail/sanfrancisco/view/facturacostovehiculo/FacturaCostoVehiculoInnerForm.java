package com.gmail.sanfrancisco.view.facturacostovehiculo;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.FacturaCostoVehiculo;
import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;
import com.gmail.sanfrancisco.view.insumocostovehiculo.InsumoCostoVehiculoForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FacturaCostoVehiculoInnerForm extends DefaultInnerDialog<FacturaCostoVehiculo> {

    private TextField id;
    private DatePicker fecha;

    private Grid<InsumoCostoVehiculo> insumoGrid;
    private UnoaMuchoGrid<FacturaCostoVehiculo, InsumoCostoVehiculo> insumos;

    public FacturaCostoVehiculoInnerForm(IPresentableForm<FacturaCostoVehiculo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("312px");
        setWidth("700px");

        id = textField("ID");
        id.setPreventInvalidInput(true);

        fecha = dateField("Fecha");
        fecha.setWidth("32%");
        fecha.setRequired(true);

        form.add(
                envolver(id, "30%"),

                envolver(fecha),
                envolver(getInsumos())
        );
    }

    private Component getInsumos() {
        insumos = new UnoaMuchoGrid<>("", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getInsumos());

        insumos.getGrid().addColumn(InsumoCostoVehiculo::getInsumo)
                .setHeader("Insumo")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("insumo")
                .setFooter("Total");

        insumos.getGrid().addColumn(InsumoCostoVehiculo::getPrecio)
                .setHeader("Precio")
                .setWidth("12%")
                .setKey("precio");
        insumos.getGrid().addColumn(InsumoCostoVehiculo::getCantidad)
                .setHeader("Cantidad")
                .setWidth("10%");

        insumos
                .withForm(InsumoCostoVehiculoForm.class)
                .withVer()
                .withNuevo(InsumoCostoVehiculo.class)
                .withEditar()
                .withBorrar()
        ;
        insumos.getGrid().setHeight("9rem");
        return insumos.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() { return fecha; }

    @Override
    public void bindFormFields(BeanValidationBinder<FacturaCostoVehiculo> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(FacturaCostoVehiculo::getId, null);

        binder.forField(fecha)
                .withConverter(new LocalDateADateConverter())
                .bind(FacturaCostoVehiculo::getFecha, FacturaCostoVehiculo::setFecha);


        binder.bindInstanceFields( this);
    }
}
