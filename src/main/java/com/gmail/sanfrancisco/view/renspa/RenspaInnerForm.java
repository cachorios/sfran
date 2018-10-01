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
    private TextField descripcion;

    public RenspaInnerForm(IPresentableForm<Renspa> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected Component generarForm() {
        id = textField("ID");
        id.setPreventInvalidInput(true);
        descripcion = textField("Descripción");

        Div form = new Div();
        form.setSizeFull();
        form.add(
                envolver(id, "30%"),
                envolver(descripcion, "50%")
        );

        return form;
    }

    @Override
    public Focusable getPrimerElementoForm() { return descripcion; }

    @Override
    public void bindFormFields(BeanValidationBinder<Renspa> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Renspa::getId, null);

        binder.bindInstanceFields(this);
    }
}
