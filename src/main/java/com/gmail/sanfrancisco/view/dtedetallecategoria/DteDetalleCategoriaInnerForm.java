package com.gmail.sanfrancisco.view.dtedetallecategoria;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;

import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;

import com.gmail.sanfrancisco.entidad.Productor;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.gmail.sanfrancisco.view.productor.ProductorCS;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;


import java.util.List;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;


public class DteDetalleCategoriaInnerForm extends DefaultInnerDialog<DteDetalleCategoria>  {
    private ProductorCS productorCS;
    private ComboBox<Renspa> renspaCombo;
    private ParamCSComponent categoria;
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

        setWidth("700px");
        productorCS = new ProductorCS("Productor", getPresentable(), true, true, true);
        renspaCombo = new ComboBox("RENSPA");
        renspaCombo.setWidth("100%");

        productorCS.addValueChangeListener(e -> {
            renspaCombo.clear();
            renspaCombo.setItems( ((Productor)e.getValue()).getRenspas());
        });

        if(this.getPresentable().getObjetoActivo() != null) {
            List<Renspa> lista = this.getPresentable().getObjetoActivo().getProductor().getRenspas();
            renspaCombo.setItems(lista);
        }

        categoria = new ParamCSComponent("Categoria", getPresentable(), true, true, "Categorias", ETipoParametro.CATEGORIA_ANIMAL);


        cantidad = textField("Cantidad");
        kgVivo = textField("Kilogramos vivos");
        precioKgVivo = textField("Precio por kg vivo");
        kgCarne = textField("Kilogramos de carne");
        porcentajeComision = textField("Porcentaje de comision");

        form.add(
                envolver(productorCS,"65%"),
                envolver(renspaCombo,"28%"),

                envolver(categoria, "50%"),
                envolver(cantidad, "24%"),
                envolver(kgVivo, "24%"),

                envolver(precioKgVivo, "33%"),
                envolver(kgCarne, "33%"),
                envolver(porcentajeComision,"33%")

        );

    }

    @Override
    public Focusable getPrimerElementoForm() {
        return renspaCombo;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<DteDetalleCategoria> binder) {

        binder.bind(productorCS,"productor");
        binder.bind(renspaCombo, "renspa");

        binder.bind(categoria, "categoria");
        binder.forField(cantidad).withConverter(new IntegerConverter()).bind("cantidad");
        binder.forField(precioKgVivo).withConverter(new DoubleConverter()).bind("precioKgVivo");
        binder.forField(kgVivo).withConverter(new DoubleConverter()).bind("kgVivo");
        binder.forField(kgCarne).withConverter(new DoubleConverter()).bind("kgCarne");
        binder.forField(porcentajeComision).withConverter(new DoubleConverter()).bind("porcentajeComision");

        binder.bindInstanceFields(this);
    }


}
