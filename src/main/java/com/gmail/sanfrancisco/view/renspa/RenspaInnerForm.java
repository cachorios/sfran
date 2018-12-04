package com.gmail.sanfrancisco.view.renspa;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class RenspaInnerForm extends DefaultInnerDialog<Renspa> {

    private TextField numeroRenspa;

    public RenspaInnerForm(IPresentableForm<Renspa> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        numeroRenspa = textField("Numero de renspa");

        form.add(
                envolver(numeroRenspa, "50%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() { return numeroRenspa; }

    @Override
    public void bindFormFields(BeanValidationBinder<Renspa> binder) {

        binder.bindInstanceFields(this);
    }
}
