package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.sanfrancisco.entidad.Faena;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;

import java.util.List;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FaenaCabecera extends Div implements HasValueAndElement<AbstractField.ComponentValueChangeEvent<FaenaCabecera, List<FaenaCabecera>>, List<FaenaCabecera>> {


    public FaenaCabecera() {
        setWidth("900px");

        add( new HorizontalLayout(
                envolver(new Label("Cat."),     "30%"),
                envolver(new Label("Cantidad"), "12%"),
                envolver(new Label("Faenado"),  "12%"),
                envolver(new Label("Dif."),     "12%"),
                envolver(new Label("Kg vivo"),  "15%"),
                envolver(new Label("a Faenar"), "15%"))
        );
        add(new Hr());
    }


    @Override
    public void setValue(List<FaenaCabecera> faenaCabeceras) {

    }

    @Override
    public List<FaenaCabecera> getValue() {
        return null;
    }

    @Override
    public Registration addValueChangeListener(ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<FaenaCabecera, List<FaenaCabecera>>> valueChangeListener) {
        return null;
    }

    protected class item {
        private ParamCSComponent categoria;
        private TextField cantidad;
        private TextField faenado;
        private TextField diferencia;
        private TextField kgVivo;
        private TextField aFaenar;
        item() {
            //categoria = new ParamCSComponent("Categoria", ((DefaultInnerDialog<>)this.getParent()).getPresentable(), true, true, "Categorias", ETipoParametro.CATEGORIA_ANIMAL);
            cantidad    = textField("Cantidad",         "12%");
            faenado     = textField("Faenado",          "12%");
            diferencia  = textField("diferencia",   "12%");
            kgVivo      = textField("Kilogramos vivos", "12%");
            aFaenar     = textField("A Faenar",         "12%");
        }

        public HorizontalLayout getItem(){
            return new HorizontalLayout(
                    cantidad,
                    faenado,
                    diferencia,
                    kgVivo,
                    aFaenar
            );
        }
    }
}
