package com.gmail.sanfrancisco.view.licencia;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class LicenciaInnerForm extends DefaultInnerDialog<Licencia> {

    private TextField id;
    private TextField tipoLicencia;
    private DatePicker vencimiento;
    private DatePicker vencimientoNac;
    private DatePicker vencimientoCurso;
    private Checkbox licenciaCarga;

    public LicenciaInnerForm(IPresentableForm<Licencia> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        id = textField("ID");
        id.setPreventInvalidInput(true);
        tipoLicencia = textField("Tipo licencia");

        vencimiento = dateField("Vencimiento");
        vencimiento.setWidth("100%");
        vencimiento.setRequired(true);

        vencimientoNac = dateField("Vencimiento Nac");
        vencimientoNac.setWidth("100%");
        vencimientoNac.setRequired(true);

        vencimientoCurso = dateField("Vencimiento Curso");
        vencimientoCurso.setWidth("100%");
        vencimientoCurso.setRequired(true);

        licenciaCarga = new Checkbox("Habilitado para carga");
        licenciaCarga.setEnabled(false);

        form.add(
                envolver(id, "30%"),
                envolver(tipoLicencia, "30%"),
                envolver(vencimiento, "50%"),
                envolver(vencimientoNac,"50%"),
                envolver(vencimientoCurso, "50%"),
                envolver(licenciaCarga,"50%")
        );
    }

    @Override
    public Focusable getPrimerElementoForm() {
        return tipoLicencia;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<Licencia> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Licencia::getId, null);

        binder.forField(tipoLicencia)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Licencia::getTipoLicencia, null);

        binder.forField(vencimiento)
                .withConverter(new LocalDateADateConverter())
                .bind(Licencia::getVencimiento, Licencia::setVencimiento);

        binder.forField(vencimientoNac)
                .withConverter(new LocalDateADateConverter())
                .bind(Licencia::getVencimientoNac, Licencia::setVencimientoNac);

        binder.forField(vencimientoCurso)
                .withConverter(new LocalDateADateConverter())
                .bind(Licencia::getVencimientoCurso, Licencia::setVencimientoCurso);

        binder.bindInstanceFields(this);
    }
}