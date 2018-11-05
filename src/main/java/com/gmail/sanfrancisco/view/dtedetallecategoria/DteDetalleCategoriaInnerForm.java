package com.gmail.sanfrancisco.view.dtedetallecategoria;

import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteDetalleCategoriaInnerForm extends DefaultInnerDialog<DteDetalleCategoria> {

    private TextField id;
    private TextField categoria;
    private TextField cantidad;
    private TextField kgVivo;
    private TextField precioKgVivo;
    private TextField kgCarne;
    private TextField porcentajeComision;

    public DteDetalleCategoriaInnerForm(IPresentableForm<DteDetalleCategoria> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        id = textField("ID");
        id.setPreventInvalidInput(true);
        categoria = textField("Categoria");
        cantidad = textField("Cantidad");
        kgVivo = textField("Kilogramos vivos");
        precioKgVivo = textField("Precio por kg vivo");
        kgCarne = textField("Kilogramos de carne");
        porcentajeComision = textField("Porcentaje de comision");

        form.add(
                envolver(id, "30%"),
                envolver(categoria, "32%"),
                envolver(cantidad, "32%"),
                envolver(precioKgVivo, "32%"),
                envolver(kgVivo, "32%"),
                envolver(kgCarne, "32%"),
                envolver(porcentajeComision,"32%")
        );

    }

    @Override
    public Focusable getPrimerElementoForm() {
        return cantidad;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<DteDetalleCategoria> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(DteDetalleCategoria::getId, null);

        binder.bind(categoria, "categoria");
        binder.forField(cantidad).withConverter(new IntegerConverter()).bind("cantidad");
        binder.forField(precioKgVivo).withConverter(new DoubleConverter()).bind("precioKgVivo");
        binder.forField(kgVivo).withConverter(new DoubleConverter()).bind("kgVivo");
        binder.forField(kgCarne).withConverter(new DoubleConverter()).bind("kgCarne");
        binder.forField(porcentajeComision).withConverter(new DoubleConverter()).bind("porcentajeComision");

        binder.bindInstanceFields(this);
    }
}
