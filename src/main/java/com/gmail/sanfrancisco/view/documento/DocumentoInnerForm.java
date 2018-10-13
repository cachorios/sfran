package com.gmail.sanfrancisco.view.documento;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.gmail.sanfrancisco.entidad.Documento;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DocumentoInnerForm extends DefaultInnerDialog<Documento> {

    private TextField id;
    private TextField nombreArchivo;
    private TextField descripcion;

    public DocumentoInnerForm(IPresentableForm<Documento> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("170px");
        setWidth("700px");

        id = textField("ID");
        id.setPreventInvalidInput(true);
        nombreArchivo = textField("Nombre de archivo");
        descripcion = textField("Descripción");

        form.add(
                envolver(id, "30%"),

                envolver(nombreArchivo,"48%"),
                envolver(descripcion,"48%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() { return nombreArchivo; }

    @Override
    public void bindFormFields(BeanValidationBinder<Documento> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Documento::getId, null);

        binder.bindInstanceFields( this);
    }
}
