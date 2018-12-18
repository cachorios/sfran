package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.sanfrancisco.entidad.FaenaDetalle;
import com.gmail.sanfrancisco.view.dte.DteCS;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.internal.AbstractFieldSupport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.shared.Registration;

import java.util.Objects;
import java.util.stream.Stream;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;


public class FaenaDetalleEditor  extends HorizontalLayout implements HasValueAndElement<AbstractField.ComponentValueChangeEvent<FaenaDetalleEditor, FaenaDetalle>, FaenaDetalle> {

    private DteCS dteCSDetalle;

    private TextField orden;
    private ParamCSComponent categoriaDetalle;
    private TextField kgIzquierdo;
    private TextField kgDerecho;


    private final AbstractFieldSupport<FaenaDetalleEditor,FaenaDetalle> fieldSupport;
    private BeanValidationBinder<FaenaDetalle> binder = new BeanValidationBinder<>(FaenaDetalle.class);

    public FaenaDetalleEditor() {
        fieldSupport = new AbstractFieldSupport<>(this,null, Objects::equals, c ->{});

        setWidth("100%");

        orden = textField("Cantidad");
        //categoriaDetalle = new ParamCSComponent("Categoria", ((DefaultInnerDialog<>)this.getParent()).getPresentable(), true, true, "Categorias", ETipoParametro.CATEGORIA_ANIMAL);
        kgIzquierdo = textField("Kilogramos izquierdo");
        kgDerecho = textField("Kilogramos derecho");

        add(
                envolver(dteCSDetalle, "30%"),
                envolver(orden, "11%"),
//                envolver(categoriaDetalle, "30%"),
                envolver(kgIzquierdo, "11%"),
                envolver(kgDerecho, "10%")
        );



    }



    @Override
    public void setValue(FaenaDetalle value) {
        fieldSupport.setValue(value);
        binder.setBean(value);
    }

    public Stream<HasValue<?, ?>> validate() {
        return binder.validate().getFieldValidationErrors().stream().map(BindingValidationStatus::getField);
    }

    @Override
    public FaenaDetalle getValue() {
        return fieldSupport.getValue();
    }

    @Override
    public Registration addValueChangeListener(ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<FaenaDetalleEditor, FaenaDetalle>> valueChangeListener) {
        return fieldSupport.addValueChangeListener(valueChangeListener);
    }
}
