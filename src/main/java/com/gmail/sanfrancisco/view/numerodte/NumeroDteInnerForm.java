package com.gmail.sanfrancisco.view.numerodte;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.NumeroDte;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class NumeroDteInnerForm extends DefaultInnerDialog<NumeroDte> {

    private TextField numero;
    private TextField numeroTropaFiscal;

    public NumeroDteInnerForm(IPresentableForm<NumeroDte> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        numero = textField("Numero");
        numeroTropaFiscal = textField("Numero de tropa fiscal");

        form.add(
                envolver(numero, "48%"),
                envolver(numeroTropaFiscal, "50%")
        );
    }

    @Override
    public Focusable getPrimerElementoForm() { return numero; }

    @Override
    public void bindFormFields(BeanValidationBinder<NumeroDte> binder) {



        binder.bindInstanceFields(this);
    }
}
