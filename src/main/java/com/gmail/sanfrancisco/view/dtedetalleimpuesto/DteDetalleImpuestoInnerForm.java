package com.gmail.sanfrancisco.view.dtedetalleimpuesto;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
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

    private TextField id;
    private TextField saldo;

    public DteDetalleImpuestoInnerForm(IPresentableForm<DteDetalleImpuesto> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        id = textField("ID");
        id.setPreventInvalidInput(true);
        saldo = textField("Saldo");

        form.add(
                envolver(id, "30%"),
                envolver(saldo, "32%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() {
        return saldo;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<DteDetalleImpuesto> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(DteDetalleImpuesto::getId, null);

        binder.forField(saldo)
                .withConverter(new StringToDoubleConverter("No es un nro válido."))
                .withNullRepresentation(0.0)
                .bind(DteDetalleImpuesto::getSaldo, DteDetalleImpuesto::setSaldo);

        binder.bindInstanceFields(this);
    }
}
