package com.gmail.sanfrancisco.view.impuestocostovehiculo;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.entidad.ImpuestoCostoVehiculo;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ImpuestoCostoVehiculoInnerForm extends DefaultInnerDialog<ImpuestoCostoVehiculo> {

    private TextField id;
    private TextField saldo;

    public ImpuestoCostoVehiculoInnerForm(IPresentableForm<ImpuestoCostoVehiculo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("588px");
        setWidth("700px");

        id = textField("ID");
        id.setPreventInvalidInput(true);
        saldo = textField("Cantidad");

        form.add(
                envolver(id, "30%"),

                envolver(saldo,"50%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() { return saldo; }

    @Override
    public void bindFormFields(BeanValidationBinder<ImpuestoCostoVehiculo> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(ImpuestoCostoVehiculo::getId, null);

        binder.forField(saldo).withConverter(new DoubleConverter()).bind("saldo");


        binder.bindInstanceFields( this);
    }
}