package com.gmail.cacho.slapi.view.layouts;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.comunes.Recursos;
import com.gmail.cacho.slapi.view.customs.tabs.CustomTabGroup;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerPanel;
import com.gmail.cacho.slapi.view.interfaces.IManagerPanel;
import com.gmail.cacho.slapi.view.interfaces.IVisualizablePanel;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;

public class DefaultInnerPanel extends VerticalLayout implements ILayoutInnerPanel {
    private IVisualizablePanel visuatable;

    private Span titulo;
    private VerticalLayout contenido;
    private HorizontalLayout botonera;
    private Button guardarButton;
    private Button cancelarButton;
    private CustomTabGroup tabs;
    protected VerticalLayout panel;
    private float formRatio = 0.5f;

    public DefaultInnerPanel(IVisualizablePanel visuatable, String elTitulo) {
        this.visuatable = visuatable;

        setearEstiloGeneral();
        generarVista(elTitulo);
    }

    protected void setearEstiloGeneral() {
        this.setMargin(true);
        this.setSpacing(false);
        this.setSizeFull();
    }

    private void generarVista(String elTitulo) {
        // 1.TITULO
        if (elTitulo != null && !elTitulo.isEmpty()) {
            titulo = new Span(elTitulo);
            //titulo.setStyleName("titulo");
            titulo.setWidth("100%");
            this.add(titulo);
            this.setFlexGrow(0, titulo);
        }

        // 2.CONTENIDO (FORM+TABS)
        contenido = generarContenido();
        panel = generarForm();
        if (visuatable.contieneTabs()) {
            tabs = generarTabs();
            VerticalLayout frame = new VerticalLayout();
            frame.setSizeFull();
            frame.add(panel, tabs);
            frame.setMargin(false);
            frame.setSpacing(false);
            frame.setFlexGrow(getFormRatio(), panel);
            frame.setFlexGrow(1 - getFormRatio(), tabs);
            contenido.add(frame);
        } else {
            contenido.add(panel);
        }

        // 3.BOTONERA
        botonera = generarBotonera();

        // 4.ARMADO FINAL
        add(contenido, botonera);
        setFlexGrow(1, contenido);        ////this.setExpandRatio(contenido, 1);
        setFlexGrow(0, botonera);         //this.setExpandRatio(botonera, 0);

        // 5.REGISTRADO DE COMPONENTES POR DEFECTO
        registrarComponentesDefault();
    }

    private VerticalLayout generarContenido() {
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();

        return content;
    }

    private CustomTabGroup generarTabs() {
        tabs.setSizeFull();
        tabs.getTabs().forEach(t -> t.getContenido().iniciar(visuatable.getModoVista(), visuatable.getObjetoMasterTab(t.getClass())));

        return tabs;
    }

    protected HorizontalLayout generarBotonera() {
        HorizontalLayout botonera = new HorizontalLayout();
        botonera.setWidth("100%");
        botonera.setHeight("50px");

        guardarButton = new Button(C.CRUD_FORM_BTN_GUARDAR);
        guardarButton.setIcon(VaadinIcon.CHECK_SQUARE_O.create());
        guardarButton.getElement().setProperty("data", Recursos.RCV_BTN_ALLCAN);
        botonera.add(guardarButton);
        botonera.setAlignSelf(Alignment.START);

        cancelarButton = new Button(C.CRUD_FORM_BTN_CANCELAR);
        cancelarButton.setIcon(VaadinIcon.CLOSE.create());
        cancelarButton.getElement().setProperty("data", Recursos.RCV_BTN_ALLCAN);
        botonera.add(cancelarButton);
        botonera.setAlignSelf(Alignment.END, cancelarButton);

        return botonera;
    }

    protected VerticalLayout generarForm() {
        return new VerticalLayout();
    }

    protected float getFormRatio() {
        return formRatio;
    }

    protected void setFormRatio(float formRatio) {
        this.formRatio = formRatio;
    }

    @Override
    public IVisualizablePanel getVisuatable() {
        return visuatable;
    }

    @Override
    public Component getLayout() {
        return this;
    }

    @Override
    public CustomTabGroup getTabs() {
        return tabs;
    }

    @Override
    public VerticalLayout getContenido() {
        return contenido;
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
    public Focusable getPrimerElementoForm() {
        return guardarButton;
    }

    @Override
    public void setEditableState(boolean enable) {
        panel.setEnabled(enable);
    }

    @Override
    public void registrarComponentesDefault() {
        if (getGuardarButton() != null) {
            visuatable.registrarComponenteVista(
                    new ComponenteVista(getGuardarButton(),
                            Arrays.asList(EModoVista.NUEVO, EModoVista.EDITAR),
                            true,
                            true,
                            Key.F9,
                            e -> ((IManagerPanel) visuatable.getManager()).formSave()));

        }
        if (getCancelarButton() != null) {
            visuatable.registrarComponenteVista(
                    new ComponenteVista(getCancelarButton(),
                            Arrays.asList(EModoVista.VER, EModoVista.NUEVO, EModoVista.EDITAR),
                            false,
                            false,
                            Key.F12,
                            e -> ((IManagerPanel) visuatable.getManager()).formClose()));
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