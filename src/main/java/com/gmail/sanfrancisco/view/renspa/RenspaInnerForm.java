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

    private TextField id;
    private TextField numeroRenspa;

    public RenspaInnerForm(IPresentableForm<Renspa> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {
        id = textField("ID");
        id.setPreventInvalidInput(true);
        numeroRenspa = textField("Numero");


        form.add(
                envolver(id, "30%"),
                envolver(numeroRenspa, "50%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() { return numeroRenspa; }

    @Override
    public void bindFormFields(BeanValidationBinder<Renspa> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Renspa::getId, null);

        binder.bindInstanceFields(this);
    }
}
