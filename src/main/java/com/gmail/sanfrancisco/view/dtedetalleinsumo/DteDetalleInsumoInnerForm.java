package com.gmail.sanfrancisco.view.dtedetalleinsumo;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteDetalleInsumoInnerForm extends DefaultInnerDialog<DteDetalleInsumo> {

    private TextField id;
    private TextField cantidad;
    private TextField precio;

    public DteDetalleInsumoInnerForm(IPresentableForm<DteDetalleInsumo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        id = textField("ID");
        id.setPreventInvalidInput(true);
        cantidad = textField("Cantidad");
        precio = textField("Precio");

        form.add(
                envolver(id, "30%"),
                envolver(cantidad),
                envolver(precio)
        );

    }

    @Override
    public Focusable getPrimerElementoForm() {
        return cantidad;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<DteDetalleInsumo> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(DteDetalleInsumo::getId, null);

        binder.forField(cantidad)
                .withConverter(new StringToIntegerConverter("No es un nro válido."))
                .withNullRepresentation(0)
                .bind(DteDetalleInsumo::getCantidad, DteDetalleInsumo::setCantidad);

        binder.forField(precio)
                .withConverter(new StringToDoubleConverter("No es un nro válido."))
                .withNullRepresentation(0.0)
                .bind(DteDetalleInsumo::getPrecio, DteDetalleInsumo::setPrecio);

        binder.bindInstanceFields(this);
    }
}
