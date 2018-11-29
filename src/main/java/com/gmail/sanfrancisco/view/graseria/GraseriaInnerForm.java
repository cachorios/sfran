package com.gmail.sanfrancisco.view.graseria;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Graseria;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleInsumo;
import com.gmail.sanfrancisco.view.graseriadetalleinsumo.GraseriaDetalleInsumoForm;
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

public class GraseriaInnerForm extends DefaultInnerDialog<Graseria> {

    private TextField id;
    private DatePicker fecha;

    private Grid<GraseriaDetalleInsumo> insumoGrid;
    private UnoaMuchoGrid<Graseria, GraseriaDetalleInsumo> insumos;

    public GraseriaInnerForm(IPresentableForm<Graseria> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {
        setWidth("680px");

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

        insumos.getGrid().addColumn(GraseriaDetalleInsumo::getInsumo)
                .setHeader("Insumo")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("insumo")
                .setFooter("Total");

        insumos.getGrid().addColumn(GraseriaDetalleInsumo::getPrecio)
                .setHeader("Precio")
                .setWidth("12%")
                .setKey("precio");
        insumos.getGrid().addColumn(GraseriaDetalleInsumo::getCantidad)
                .setHeader("Cantidad")
                .setWidth("10%");

        insumos
                .withForm(GraseriaDetalleInsumoForm.class)
                .withVer()
                .withNuevo(GraseriaDetalleInsumo.class)
                .withEditar()
                .withBorrar()
        ;
        insumos.getGrid().setHeight("9rem");
        return insumos.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() { return fecha; }

    @Override
    public void bindFormFields(BeanValidationBinder<Graseria> binder) {

        binder.forField(id)
        .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
        .withNullRepresentation(0l)
        .bind(Graseria::getId, null);

        binder.forField(fecha)
        .withConverter(new LocalDateADateConverter())
        .bind(Graseria::getFecha, Graseria::setFecha);


        binder.bindInstanceFields( this);
    }
}
