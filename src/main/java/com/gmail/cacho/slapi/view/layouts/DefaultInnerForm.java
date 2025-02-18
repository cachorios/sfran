package com.gmail.cacho.slapi.view.layouts;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.comunes.R;
import com.gmail.cacho.slapi.comunes.Recursos;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTabGroup;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.Arrays;
import java.util.Collections;

@Tag("form-view")
@HtmlImport("frontend://src/components/crud/form-view.html")
public class DefaultInnerForm<T extends AbstractEntidad> extends PolymerTemplate<DefaultInnerForm.BindingModel> implements ILayoutInnerForm<T> {
    public interface BindingModel extends TemplateModel {
        void setTitulo(String titulo);
    }

    private IPresentableForm<T> presentable;
    @Id("titulo")
    private H2 titulo;
    @Id("contenido")
    private Div contenido;
    @Id("botonera")
    private Div botonera;

    private Button guarAddButton;
    private Button guardarButton;
    private Button cancelarButton;

    private CustomTabGroup tabs;
    protected Component form;

    private float formRatio = 1f;

    public DefaultInnerForm(IPresentableForm<T> presentable, String elTitulo) {
        this.presentable = presentable;

        setearEstiloGeneral();
        generarVista(elTitulo);
    }

    protected void setearEstiloGeneral() {
//        setClassName("v-form");
//        this.setSizeFull();
    }

    private void generarVista(String eltitulo) {
        // 1.TITULO

        generarTitulo(eltitulo);

        // 2.CONTENIDO (FORM+TABS)
        //contenido = generarContenido();
        form = generarForm();

        if (presentable.contieneTabs()) {
            /*tabs = generarTabs();
            VerticalLayout frame = new VerticalLayout();
            frame.setSizeFull();
            frame.add(form, tabs);
            frame.setMargin(false);
            frame.setSpacing(false);
            frame.setPadding(false);
            frame.setFlexGrow(getFormRatio(), form);
            frame.setFlexGrow(1.0f - getFormRatio(), tabs);
            contenido.add(frame);*/
        } else {
            contenido.add(form);
        }


        // 3.BOTONERA
        generarBotonera();

        // 4.ARMADO FINAL
        ////////////////this.add(titulo, contenido, botonera);
        //setearFlexGrow();

        // 5.REGISTRADO DE COMPONENTES POR DEFECTO
        registrarComponentesDefault();
        //setearShortcuts();
    }

    protected  void generarTitulo(String eltitulo) {
        titulo.setVisible(eltitulo != null && !eltitulo.isEmpty());
//        if (titulo.isVisible() ) {
//        }
    }

//    private VerticalLayout generarContenido() {
//        VerticalLayout content = new VerticalLayout();
//        content.setClassName("content");
//        content.setSizeFull();
////        this.setPadding(false);
////        this.setMargin(false);
////        this.setSpacing(false);
//        return content;
//    }


    private CustomTabGroup generarTabs() {
        tabs = presentable.getTabGroup();
        tabs.setMargin(false);
        tabs.setPadding(false);
        tabs.setFlexGrow(1L);
        tabs.iniciar(presentable.getModoVista(), presentable.getObjetoActivo());
        tabs.setVisible(true);

        return tabs;

    }

    protected void generarBotonera() {

        generarGuardarButton();
        generarGuarAddButton();
        generarCancelarButton();
        botonera.add(guardarButton,guarAddButton, cancelarButton);


    }

    protected void setearFlexGrow() {
//        this.setFlexGrow(0, titulo);
//        this.setFlexGrow(1,contenido);
//        this.setFlexGrow(0, botonera);
    }

    protected void generarGuardarButton() {
        guardarButton = new Button(C.CRUD_FORM_BTN_GUARDAR);
        //// guardarButton.setStyleName("small");
        guardarButton.setIcon(VaadinIcon.CHECK_SQUARE_O.create());
        guardarButton.getElement().setProperty("data", R.RCV_BTN_ALLCAN);
    }

    protected void generarGuarAddButton() {
        guarAddButton = new Button(C.CRUD_FORM_BTN_GUARADD);
        //// guarAddButton.setStyleName("small");
        guarAddButton.setIcon(VaadinIcon.CHECK_SQUARE_O.create());
        guarAddButton.getElement().setProperty("data", R.RCV_BTN_ALLCAN);
    }

    protected void generarCancelarButton() {
        cancelarButton = new Button(C.CRUD_FORM_BTN_CANCELAR);
        //// cancelarButton.setStyleName("small");
        cancelarButton.setIcon(VaadinIcon.CLOSE.create());
        cancelarButton.getElement().setProperty("data", R.RCV_BTN_ALLCAN);
    }

    protected Component generarForm() {
        Component form =  new Div();
        ((HasStyle)form).setClassName("panel");
        return form;
    }

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
        form.getElement().setAttribute("enabled", true);
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