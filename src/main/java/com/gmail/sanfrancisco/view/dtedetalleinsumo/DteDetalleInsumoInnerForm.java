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
    protected Component generarForm() {

        id = textField("ID");
        id.setPreventInvalidInput(true);
        cantidad = textField("Cantidad");
        precio = textField("Precio");

        Div form = new Div();
        form.setSizeFull();
        form.add(
                envolver(id, "30%"),
                envolver(cantidad),
                envolver(precio)
        );


        return form;
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

        binder.bindInstanceFields(this);
    }
}
