package com.gmail.cacho.slapi.view.componentes;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.dom.DebouncePhase;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("tool-bar")
@HtmlImport("src/components/crud/tool-bar.html")
public class ToolBar extends PolymerTemplate<ToolBar.Model> {

    public interface Model extends TemplateModel {
        boolean isCheckboxChecked();

        void setCheckboxChecked(boolean checkboxChecked);

        void setCheckboxText(String checkboxText);

        void setVerText(String actionText);

        void setNuevoText(String actionText);

        void setEditarText(String actionText);

        void setBorrarText(String actionText);
    }

    @Id("field")
    private TextField textField;

    @Id("clear")
    private Button clearButton;


    @Id("botonera")
    private Div botonera;
    //@Id("action")
    private Button actionButton;

    @Id("verButton")
    private Button verButton;

    @Id("nuevoButton")
    private Button nuevoButton;

    @Id("editarButton")
    private Button editarButton;

    @Id("borrarButton")
    private Button borrarButton;

    public ToolBar() {
        textField.setValueChangeMode(ValueChangeMode.EAGER);
        ComponentUtil.addListener(textField, SearchValueChanged.class, e -> fireEvent(new FilterChanged(this, false)));
        clearButton.addClickListener(e -> {
            textField.clear();
            getModel().setCheckboxChecked(false);
        });

        getElement().addPropertyChangeListener("checkboxChecked", e -> fireEvent(new FilterChanged(this, false)));
    }

    public String getFilter() {
        return textField.getValue();
    }

    public boolean isCheckboxChecked() {
        return getModel().isCheckboxChecked();
    }

    public void setPlaceHolder(String placeHolder) {
        textField.setPlaceholder(placeHolder);
    }

    public void setVerText(String actionText) {
        getModel().setVerText(actionText);
    }

    public void setNuevoText(String actionText) {
        getModel().setNuevoText(actionText);
    }

    public void setEditarText(String actionText) {
        getModel().setEditarText(actionText);
    }

    public void setBorrarText(String actionText) {
        getModel().setBorrarText(actionText);
    }

    public void setCheckboxText(String checkboxText) {
        getModel().setCheckboxText(checkboxText);
    }

    public void addFilterChangeListener(ComponentEventListener<FilterChanged> listener) {
        this.addListener(FilterChanged.class, listener);
    }

    public void addVerClickListener(ComponentEventListener<ClickEvent<Button>> listener) {
        verButton.addClickListener(listener);
    }

    public void addANuevoClickListener(ComponentEventListener<ClickEvent<Button>> listener) {
        nuevoButton.addClickListener(listener);
    }

    public void addEditarClickListener(ComponentEventListener<ClickEvent<Button>> listener) {
        editarButton.addClickListener(listener);
    }

    public void addBorrarClickListener(ComponentEventListener<ClickEvent<Button>> listener) {
        borrarButton.addClickListener(listener);
    }

    @DomEvent(value = "value-changed", debounce = @DebounceSettings(timeout = 300, phases = DebouncePhase.TRAILING))
    public static class SearchValueChanged extends ComponentEvent<TextField> {
        public SearchValueChanged(TextField source, boolean fromClient) {
            super(source, fromClient);
        }
    }

    public static class FilterChanged extends ComponentEvent<ToolBar> {
        public FilterChanged(ToolBar source, boolean fromClient) {
            super(source, fromClient);
        }
    }

    public Button getVerButton() {
        return verButton;
    }

    public Button getNuevoButton() {
        return nuevoButton;
    }

    public Button getEditarButton() {
        return editarButton;
    }

    public Button getBorrarButton() {
        return borrarButton;
    }

    public TextField getTextFieldFilter(){
        return textField;
    }

    public Div getBotonera() {
        return botonera;
    }
}
