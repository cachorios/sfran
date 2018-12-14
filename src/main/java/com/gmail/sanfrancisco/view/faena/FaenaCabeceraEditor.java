package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.cacho.slapi.view.interfaces.IPresentable;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.gmail.sanfrancisco.entidad.FaenaCabezera;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.internal.AbstractFieldSupport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import com.vaadin.flow.shared.Registration;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;

public class FaenaCabeceraEditor extends Div implements HasValueAndElement<AbstractField.ComponentValueChangeEvent<FaenaCabeceraEditor, List<FaenaCabezera>>, List<FaenaCabezera>> {

    IPresentable padre;

    private final AbstractFieldSupport<FaenaCabeceraEditor,List<FaenaCabezera>> fieldSupport;

    private boolean hasChanges = false;
//    private BeanValidationBinder<FaenaCabezera> binderFC = new BeanValidationBinder<>(FaenaCabezera.class);
    public FaenaCabeceraEditor(IPresentable padre) {
        this.padre = padre;
        this.fieldSupport = new AbstractFieldSupport<>(this, Collections.emptyList(),
                Objects::equals, c ->  {});

        setWidth("100%");

        cabecera();
    }

    private void cabecera() {
        HorizontalLayout hlLabel = new HorizontalLayout(
                envolver(new Label("Categoria"), "40%"),
                envolver(new Label("Cantidad"), "10%"),
                envolver(new Label("Faenado"), "10%"),
                envolver(new Label("Dif."), "10%"),
                envolver(new Label("Kg vivo"), "10%"),
                envolver(new Label("a Faenar"), "10%"),
                envolver(new Label("Accion"), "10%")
        );
        hlLabel.setWidth("100%");
        add( hlLabel
        );
        add(new Hr());
    }

    @Override
    public void setValue(List<FaenaCabezera> faenaCabezeras) {
        fieldSupport.setValue(faenaCabezeras);
        hasChanges = false;
        removeAll();
        cabecera();

        if (faenaCabezeras != null) {
            faenaCabezeras.forEach(this::createItem);
        }
        setHasChanges(false);
    }

    private Item createItem(FaenaCabezera faenaCabezera) {
        Item item = new Item();
        add(item);
        item.setValue(faenaCabezera);
        return item;
    }


    @Override
    public List<FaenaCabezera> getValue() {
        return fieldSupport.getValue();
    }

    @Override
    public Registration addValueChangeListener(ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<FaenaCabeceraEditor, List<FaenaCabezera>>> valueChangeListener) {
        return fieldSupport.addValueChangeListener(valueChangeListener);
    }

    public boolean hasChanges() {
        return hasChanges;
    }

    private void setHasChanges(boolean hasChanges) {
        this.hasChanges = hasChanges;
        if (hasChanges) {
            ///fireEvent(new com.gmail..views.sfran.events.ValueChangeEvent(this));
        }
    }


    protected class Item extends HorizontalLayout implements HasValueAndElement<AbstractField.ComponentValueChangeEvent<Item, FaenaCabezera>, FaenaCabezera> {
        private ParamCSComponent categoria;
        private TextField cantidad;
        private TextField faenado;
        private TextField diferencia;
        private TextField kgVivo;
        private TextField aFaenar;
        private Button btnAgregar;
        private final AbstractFieldSupport<Item, FaenaCabezera> fieldSupport;
        private BeanValidationBinder<FaenaCabezera> binder = new BeanValidationBinder<>(FaenaCabezera.class);
        private List dato;

        Item() {
            this.setWidth("100%");
            this.fieldSupport = new AbstractFieldSupport<>(this, null, Objects::equals, c -> {});

            categoria = new ParamCSComponent("", padre , true, true, "Categorias", ETipoParametro.CATEGORIA_ANIMAL);
            categoria.setEnabled(false);

            cantidad    = new TextField(); cantidad.setWidth("10%");    cantidad.setEnabled(false);
            faenado     = new TextField(); faenado.setWidth("10%");     faenado.setEnabled(false);
            diferencia  = new TextField(); diferencia.setWidth("10%");  diferencia.setEnabled(false);
            kgVivo      = new TextField(); kgVivo.setWidth("10%");      kgVivo.setEnabled(false);

            aFaenar     = new TextField(); aFaenar.setWidth("10%");
            btnAgregar = new Button("Carga", e->{});

            binder.forField(aFaenar)
                    .withConverter(new IntegerConverter())
                    .bind("cantidad");

            add(
                envolver(categoria,"40%"),
                cantidad,
                faenado,
                diferencia,
                kgVivo,
                aFaenar,
                envolver(btnAgregar,"10%")
            );
        }


        @Override
        public void setValue(FaenaCabezera faenaCabezera) {
            fieldSupport.setValue(faenaCabezera);
            DteDetalleCategoria d = faenaCabezera.getCategoria();
            categoria.setValue(d.getCategoria());
            cantidad.setValue(d.getCantidad().toString());
            kgVivo.setValue(d.getKgVivo().toString());
            faenado.setValue(faenaCabezera.getFaenado().toString());
            Integer dif = 0;
            dif = d.getCantidad() - faenaCabezera.getFaenado();
            diferencia.setValue( dif.toString() );

            binder.setBean(faenaCabezera);
        }

        @Override
        public FaenaCabezera getValue() {
            return null;
        }

        @Override
        public Registration addValueChangeListener(ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<Item, FaenaCabezera>> valueChangeListener) {
            return null;
        }

    }
}
