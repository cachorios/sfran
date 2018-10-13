package com.gmail.sanfrancisco.view.facturacostovehiculo;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.FacturaCostoVehiculo;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FacturaCostoVehiculoInnerForm extends DefaultInnerDialog<FacturaCostoVehiculo> {

    private TextField id;
    private DatePicker fecha;

    public FacturaCostoVehiculoInnerForm(IPresentableForm<FacturaCostoVehiculo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("252px");
        setWidth("700px");

        id = textField("ID");
        id.setPreventInvalidInput(true);

        fecha = dateField("Fecha");
        fecha.setWidth("100%");
        fecha.setRequired(true);

        form.add(
                envolver(id, "30%"),

                envolver(fecha,"50%")
        );
    }

    @Override
    public Focusable getPrimerElementoForm() { return fecha; }

    @Override
    public void bindFormFields(BeanValidationBinder<FacturaCostoVehiculo> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(FacturaCostoVehiculo::getId, null);

        binder.forField(fecha)
                .withConverter(new LocalDateADateConverter())
                .bind(FacturaCostoVehiculo::getFecha, FacturaCostoVehiculo::setFecha);


        binder.bindInstanceFields( this);
    }
}
