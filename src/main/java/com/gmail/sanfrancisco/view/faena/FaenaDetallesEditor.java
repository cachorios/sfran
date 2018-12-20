package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.sanfrancisco.entidad.Faena;
import com.gmail.sanfrancisco.entidad.FaenaDetalle;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.internal.AbstractFieldSupport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.shared.Registration;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;

@Tag("faena-detalle")
@HtmlImport("src/views/faena/faena-detalle.html")
public class FaenaDetallesEditor extends Div implements HasValueAndElement<AbstractField.ComponentValueChangeEvent<FaenaDetallesEditor, List<FaenaDetalle>>, List<FaenaDetalle>>, IVisualizable {
    private IPresentableForm<Faena> padre;
    private final AbstractFieldSupport<FaenaDetallesEditor, List<FaenaDetalle>> fieldSupport;
    private boolean hasChanges = false;
    private int index;
    public FaenaDetallesEditor(IPresentableForm<Faena> presentable) {
        this.fieldSupport = new AbstractFieldSupport<>(this, Collections.emptyList(), Objects::equals, c -> {});
        this.padre = presentable;
        setWidth("100%");
    }



    @Override
    public void setValue(List<FaenaDetalle> items) {
        fieldSupport.setValue(items);
        removeAll();
        hasChanges = false;
        if(items != null){
            index = 0;
            items.forEach(this::createEditor);
        }
        setHasChanges(false);
    }

    private void createEditor(FaenaDetalle item) {
        index ++;
        FaenaDetalleEditor editor = new FaenaDetalleEditor(padre, index);
        editor.setValue(item);
        add(editor);
    }

    public Stream<HasValue<?, ?>> validate() {
        return getChildren()
                .filter(component -> fieldSupport.getValue().size() == 0 )
                .map(editor -> ((FaenaDetalleEditor) editor).validate()).flatMap(stream -> stream);
    }

    @Override
    public List<FaenaDetalle> getValue() {
        return fieldSupport.getValue();
    }

    @Override
    public Registration addValueChangeListener(ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<FaenaDetallesEditor, List<FaenaDetalle>>> valueChangeListener) {
        return fieldSupport.addValueChangeListener(valueChangeListener);
    }

    private void setHasChanges(boolean hasChanges) {
        this.hasChanges = hasChanges;
        if (hasChanges) {
            //fireEvent(new com.gmail.luis.ui.views.storefront.events.ValueChangeEvent(this));
        }
    }

        @Override
        public void iniciar(EModoVista modo, AbstractEntidad item) {

        }

        @Override
        public EModoVista getModoVista() {
            return null;
        }

        @Override
        public Component getViewComponent() {
            return null;
        }

        @Override
        public void cerrar() {

        }

        @Override
        public IVisualizable getPadre() {
            return null;
        }

        @Override
        public void setPadre(IVisualizable padre) {

        }
    }
