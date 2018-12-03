package com.gmail.sanfrancisco.view.vehiculocostoinsumoimpuesto;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumoImpuesto;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class VehiculoCostoInsumoImpuestoInnerForm extends DefaultInnerDialog<VehiculoCostoInsumoImpuesto> {

    private ParamCSComponent impuesto;
    private TextField saldo;

    public VehiculoCostoInsumoImpuestoInnerForm(IPresentableForm<VehiculoCostoInsumoImpuesto> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("100px");
        setWidth("700px");

        saldo = textField("Cantidad");

        impuesto = new ParamCSComponent("Impuestos", getPresentable(), true, true, "Impuestos", ETipoParametro.IMPUESTO);

        form.add(
                envolver(impuesto, "50%"),

                envolver(saldo,"32%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() { return saldo; }

    @Override
    public void bindFormFields(BeanValidationBinder<VehiculoCostoInsumoImpuesto> binder) {

        binder.bind(impuesto, "impuesto");

        binder.forField(saldo).withConverter(new DoubleConverter()).bind("saldo");


        binder.bindInstanceFields( this);
    }
}