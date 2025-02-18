package com.gmail.sanfrancisco.view.dtedetalleimpuesto;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.entidad.DteDetalleImpuesto;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteDetalleImpuestoInnerForm extends DefaultInnerDialog<DteDetalleImpuesto> {

    private ParamCSComponent impuesto;
    private TextField saldo;

    public DteDetalleImpuestoInnerForm(IPresentableForm<DteDetalleImpuesto> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {
        setWidth("700px");

        impuesto = new ParamCSComponent("Impuesto", getPresentable(), true, true, "Impuestos", ETipoParametro.IMPUESTO);

        saldo = textField("Saldo");

        form.add(
                envolver(impuesto, "55%"),
                envolver(saldo, "32%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() {
        return saldo;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<DteDetalleImpuesto> binder) {

        binder.bind(impuesto, "impuesto");

        binder.forField(saldo).withConverter(new DoubleConverter()).bind("saldo");

        binder.bindInstanceFields(this);
    }
}
