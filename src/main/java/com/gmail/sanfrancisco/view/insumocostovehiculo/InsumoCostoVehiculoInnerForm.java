package com.gmail.sanfrancisco.view.insumocostovehiculo;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class InsumoCostoVehiculoInnerForm extends DefaultInnerDialog<InsumoCostoVehiculo> {

    private TextField id;
    private TextField cantidad;
    private TextField precio;

    public InsumoCostoVehiculoInnerForm(IPresentableForm<InsumoCostoVehiculo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("588px");
        setWidth("700px");

        id = textField("ID");
        id.setPreventInvalidInput(true);
        cantidad = textField("Cantidad");
        precio = textField("Precio");

        form.add(
                envolver(id, "30%"),

                envolver(cantidad,"48%"),
                envolver(precio,"48%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() { return precio; }

    @Override
    public void bindFormFields(BeanValidationBinder<InsumoCostoVehiculo> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(InsumoCostoVehiculo::getId, null);

        binder.forField(precio)
                .withConverter(new StringToDoubleConverter("No es un nro válido."))
                .withNullRepresentation(0.0)
                .bind(InsumoCostoVehiculo::getPrecio, InsumoCostoVehiculo::setPrecio);


        binder.bindInstanceFields( this);
    }
}