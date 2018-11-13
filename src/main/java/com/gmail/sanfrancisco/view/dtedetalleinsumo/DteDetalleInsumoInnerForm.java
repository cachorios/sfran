package com.gmail.sanfrancisco.view.dtedetalleinsumo;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;
import com.gmail.sanfrancisco.view.insumo.InsumoCS;
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

    private InsumoCS insumoCS;
    private TextField cantidad;
    private TextField precio;

    public DteDetalleInsumoInnerForm(IPresentableForm<DteDetalleInsumo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        insumoCS = new InsumoCS("Insumo", getPresentable(), true, true, true);

        cantidad = textField("Cantidad");
        precio = textField("Precio");

        form.add(
                envolver(insumoCS),
                envolver(cantidad, "48%"),
                envolver(precio, "48%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() {
        return cantidad;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<DteDetalleInsumo> binder) {

        binder.bind(insumoCS, "insumo");

        binder.forField(cantidad).withConverter(new IntegerConverter()).bind("cantidad");

        binder.forField(precio).withConverter(new DoubleConverter()).bind("precio");

        binder.bindInstanceFields(this);
    }
}
