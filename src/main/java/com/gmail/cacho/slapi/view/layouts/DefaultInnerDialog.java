package com.gmail.cacho.slapi.view.layouts;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.comunes.R;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTabGroup;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;

import com.vaadin.flow.component.icon.VaadinIcon;

import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.Arrays;
import java.util.Collections;

@Tag("form-dialog")
@HtmlImport("frontend://src/components/crud/form-dialog.html")
public class DefaultInnerDialog<T extends AbstractEntidad> extends PolymerTemplate<DefaultInnerDialog.BindingModel> implements ILayoutInnerForm<T> {

    public interface BindingModel extends TemplateModel {
        void setTitulo(String titulo);
    }

    private final Dialog dialog = new Dialog();

    private IPresentableForm<T> presentable;

    @Id("titulo")
    private H2 titulo;
    @Id("contenido")
    private Div contenido;
    @Id("botonera")
    private Div botonera;
    @Id("tabs-container")
    private Div tabContainer;

    private Button guarAddButton;
    private Button guardarButton;
    private Button cancelarButton;

    private CustomTabGroup tabs;
    protected Component form;

    private float formRatio = 0.5f;

    public DefaultInnerDialog(IPresentableForm<T> presentable, String elTitulo) {
        this.presentable = presentable;

        setearEstiloGeneral();
        generarVista(elTitulo);
    }

    protected void setearEstiloGeneral() {
        dialog.setHeight("600px");
        dialog.setWidth("800px");
        dialog.setCloseOnEsc(false);
        dialog.setCloseOnOutsideClick(false);

    }

    public void setHeight(String alto){
        dialog.setHeight(alto);
    }

    public void setWidth(String ancho){
        dialog.setWidth(ancho);
    }

    private void generarVista(String elTitulo) {
        // 1.TITULO
        generarTitulo(elTitulo);
        generarForm(contenido);


        tabContainer.setVisible(false);
        if (presentable.contieneTabs()) {
            tabs = generarTabs();
            tabContainer.setVisible(true);
            tabContainer.add(tabs);

            ///tabContainer.setFlexGrow(1.0f - getFormRatio(), tabs);
        }

        // 3.BOTONERA
        generarBotonera();

        guarAddButton.setClassName("crud_btn");
        guardarButton.setClassName("crud_btn");
        cancelarButton.setClassName("crud_btn");

        // 5.REGISTRADO DE COMPONENTES POR DEFECTO
        registrarComponentesDefault();
        setearShortcuts();
        generarContenido();
    }

    protected void generarTitulo(String elTitulo) {
        titulo.setVisible(elTitulo != null && !elTitulo.isEmpty());
        if (titulo.isVisible()) {
            titulo.setText(elTitulo);
        }

    }

    protected void generarContenido() {
        dialog.add(this);
    }

    protected CustomTabGroup generarTabs() {
        tabs = presentable.getTabGroup();
        tabs.setMargin(false);
        tabs.setPadding(false);
        tabs.setFlexGrow(1L);
        tabs.iniciar(presentable.getModoVista(), presentable.getObjetoActivo());
        tabs.setVisible(true);

        return tabs;
    }

    protected Div generarBotonera() {

        generarGuardarButton();
        generarGuarAddButton();
        generarCancelarButton();
        botonera.add(guardarButton,guarAddButton, cancelarButton);
        return botonera;
    }

    protected void generarGuardarButton() {
        guardarButton = new Button(C.CRUD_FORM_BTN_GUARDAR);
        guardarButton.getElement().setAttribute("theme", "primary");

        guardarButton.setIcon(VaadinIcon.CHECK_SQUARE_O.create());
        guardarButton.getElement().setProperty("data", R.RCV_BTN_ALLCAN);
    }

    protected void generarGuarAddButton() {
        guarAddButton = new Button(C.CRUD_FORM_BTN_GUARADD);
        guarAddButton.getElement().setAttribute("theme", "primary");
        guarAddButton.setIcon(VaadinIcon.CHECK_SQUARE_O.create());
        guarAddButton.getElement().setProperty("data", R.RCV_BTN_ALLCAN);
    }

    protected void generarCancelarButton() {
        cancelarButton = new Button(C.CRUD_FORM_BTN_CANCELAR);
        cancelarButton.getElement().setAttribute("theme", "primary");

        cancelarButton.setIcon(VaadinIcon.CLOSE.create());
        cancelarButton.getElement().setProperty("data", R.RCV_BTN_ALLCAN);
    }

    protected void generarForm(Div form) {}

    protected float getFormRatio() {
        return formRatio;
    }

    protected void setFormRatio(float formRatio) {
        this.formRatio = formRatio;
    }

    protected void setearShortcuts() {
        //// componentesVista.stream()
        ////                 .filter(b -> b.getShortcut() != null)
        ////                .forEach(b -> b.getComponente().setClickShortcut(b.getShortcut()));
    }

    @Override
    public void mostrar() {
        dialog.open();
    }

    @Override
    public IPresentableForm<T> getPresentable() {
        return presentable;
    }

    @Override
    public CustomTabGroup getTabs() {
        return tabs;
    }

    @Override
    public Component getContenido() {
        return contenido;
    }

    @Override
    public Button getGuarAddButton() {
        return guarAddButton;
    }

    @Override
    public Button getGuardarButton() {
        return guardarButton;
    }

    @Override
    public Button getCancelarButton() {
        return cancelarButton;
    }

    @Override
    public void cerrar() {
        dialog.close();
    }

    @Override
    public Focusable getPrimerElementoForm() {
        return guardarButton;
    }

    @Override
    public Component getLayout() {
        return this;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<T> binder) {
        binder.bindInstanceFields(getLayout());
    }

    @Override
    public void setEditableState(boolean enable) {
        contenido.setEnabled(enable);
    }

    @Override
    public void registrarComponentesDefault() {
        if (getGuardarButton() != null) {
            presentable.registrarComponenteVista(
                    new ComponenteVista(getGuardarButton(),

                            Arrays.asList(EModoVista.NUEVO, EModoVista.EDITAR),
                            true,
                            true,
                            Key.F9,
                            e -> ((IPresenterForm<T>) presentable.getPresenter()).formSave()));
        }
        if (getGuarAddButton() != null) {
            presentable.registrarComponenteVista(
                    new ComponenteVista(getGuarAddButton(),
                            Collections.singletonList(EModoVista.NUEVO),
                            true,
                            true,
                            Key.F10,
                            e -> ((IPresenterForm<T>) presentable.getPresenter()).formSaveAndAdd()));
        }
        if (getCancelarButton() != null) {
            presentable.registrarComponenteVista(
                    new ComponenteVista(getCancelarButton(),
                            Arrays.asList(EModoVista.VER, EModoVista.NUEVO, EModoVista.EDITAR),
                            false,
                            false,
                            Key.F12,
                            e -> ((IPresenterForm<T>) presentable.getPresenter()).formClose()));
        }
    }

    @Override
    public void setEstiloVisual(String estilo, String valor) {
        getElement().getStyle().set(estilo, valor);
    }

    @Override
    public String getEstiloVisual(String estilo) {
        return getElement().getStyle().get(estilo);
    }
}