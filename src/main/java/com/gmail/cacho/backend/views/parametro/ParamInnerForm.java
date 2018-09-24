package com.gmail.cacho.backend.views.parametro;


import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.backend.jpa.convert.StringADoubleConverter;
import com.gmail.cacho.backend.jpa.convert.StringAIntegerConverter;
import com.gmail.cacho.backend.jpa.convert.StringALongConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.cacho.slbase.core.Constantes;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.*;


public class ParamInnerForm extends DefaultInnerDialog<Parametro> {
    private TextField id;
    private ComboBox<ETipoParametro> tipo;
    private TextField clase;
    private TextField orden;
    private TextField nombre;
    private TextField valorint;
    private TextField valordob;
    private TextField valorstr;
    private Checkbox  valorbol;
    private DatePicker valordat;
    private TextField valorchr;

    public ParamInnerForm(IPresentableForm<Parametro> presentable, String elParametro) {
        super(presentable, elParametro);
    }

    @Override
    protected Component generarForm() {
        //setFormRatio(0.65f);
        setFormRatio(1);

        id = textField("ID");

        tipo = new ComboBox<>(Parametro.F_PAR_TIPO);
        tipo.setItems(ETipoParametro.values());
        tipo.setWidth("100%");
        tipo.setPreventInvalidInput(true);
        tipo.setRequired(true);


        clase = textField(Parametro.F_PAR_CLASE);
        orden = textField(Parametro.F_PAR_ORDEN);
        nombre = textField(Parametro.F_PAR_NOMBRE);

        valorint = textField(Parametro.F_PAR_VALORINT);
        valordob = textField(Parametro.F_PAR_VALORDOB);

        valorstr = textField(Parametro.F_PAR_VALORSTR);
        valorbol = new Checkbox(Parametro.F_PAR_VALORBOL);
        valorchr = textField(Parametro.F_PAR_VALORCHR);
        valordat = dateField(Parametro.F_PAR_VALORDAT);



        ////tipo.setEmptySelectionAllowed(false);
        ////tipo.setTextInputAllowed(false);

        Div form = new Div();
        form.setSizeFull();

        form.add(
                envolver(id, "30%"),

                envolver(tipo),

                envolver(clase, "35%"),
                envolver(orden, "15%"),
                envolver(nombre, "45%"),

                envolver(valorint, "25%"),
                envolver(valordob, "25%"),
                envolver(valordat, "30%"),
                envolver(valorchr, "12%"),

                envolver(valorstr),
                envolver(espacio()),
                envolver(valorbol, "40%")
        );
        return form;

    }

    @Override
    public Focusable getPrimerElementoForm() {
        return id;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<Parametro> binder) {
        binder.forField(id)
              .withConverter(new StringToLongConverter(Constantes.MSJ_ERR_DB_ATCONVERTDATA
                                                               .concat(Constantes.MSJ_ERR_DB_NEEDINTEGER)))
              .bind(Parametro::getId, null);
        binder.forField(orden)
              .withConverter(new StringAIntegerConverter())
              .bind(Parametro::getOrden, Parametro::setOrden);
        binder.forField(valorint)
              .withConverter(new StringALongConverter())
              .bind(Parametro::getValorint, Parametro::setValorint);
        binder.forField(valordob)
              .withConverter(new StringADoubleConverter())
              .bind(Parametro::getValordob, Parametro::setValordob);
        binder.forField(valordat)
              .withConverter(new LocalDateADateConverter())
              .bind(Parametro::getValordat, Parametro::setValordat);
//        binder.forField(valorchr)
//              .withConverter(new StringACharConverter())
//              .bind(Parametro::getValorchr, Parametro::setValorchr);


        binder.bindInstanceFields(this);
    }    
}
