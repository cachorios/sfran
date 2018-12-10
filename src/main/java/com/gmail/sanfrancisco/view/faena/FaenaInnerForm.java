package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.dataProvider.DteDataProvider;
import com.gmail.sanfrancisco.entidad.Faena;
import com.gmail.sanfrancisco.view.productor.ProductorCS;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FaenaInnerForm extends DefaultInnerDialog<Faena> {
    private DatePicker fecha;
    private TextField numero;

    public FaenaInnerForm(IPresentableForm<Faena> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        numero = textField("Numero");
        fecha = dateField("Fecha");

        form.add(
                envolver(fecha, "48%"),
                envolver(numero, "50%")

        );
    }

    @Override
    public Focusable getPrimerElementoForm() { return numero; }

    @Override
    public void bindFormFields(BeanValidationBinder<Faena> binder) {
        binder.forField(fecha)
                .withConverter(new LocalDateADateConverter())
                .bind(Faena::getFecha, Faena::setFecha);

        binder.forField(numero).withConverter(new IntegerConverter()).bind("numero");

        binder.bindInstanceFields(this);
    }
}
