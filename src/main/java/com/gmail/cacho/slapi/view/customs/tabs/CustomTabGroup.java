package com.gmail.cacho.slapi.view.customs.tabs;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.ILayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomTabGroup extends VerticalLayout {
    private Tabs tabgroup = new Tabs();
    private Div divgroup = new Div();
    private Set<CustomTab> tabs = new HashSet<>();
    private CustomTab actual;
    private boolean estaCargando;

    public CustomTabGroup(CustomTab... tab) {
        super();
        Arrays.stream(tab).forEach(this::add);
        generarVista();
        establecerComportamientoDefault();
    }

    private void generarVista() {
        tabgroup.setHeight("20px");
        divgroup.getElement().getStyle().set("padding", "0");
        divgroup.setHeight("120px");
        divgroup.setWidth("100%");
        add(tabgroup, divgroup);
    }

    private CustomTab preformatearContenidoTab(CustomTab tab) {
        ((ILayout)tab.getContenido().getViewComponent()).setEstiloVisual("height", "200px");
        ((ILayout)tab.getContenido().getViewComponent()).setEstiloVisual("padding", "0");
        ((ILayout)tab.getContenido().getViewComponent()).setEstiloVisual("margin", "0");
        tab.setContenidoVisible(false);

        return tab;
    }

    private void establecerComportamientoDefault() {
        tabgroup.addSelectedChangeListener(e -> {
            if (!estaCargando) {
                this.setActual((CustomTab) tabgroup.getSelectedTab());
            }
        });
    }

    private void add(CustomTab tab) {
        estaCargando = true;
        if (!tabs.contains(tab)) {
            tabgroup.add(tab);

            if (tabs.size() == 1) {
                setActual(tab);
            }
        }
        estaCargando = false;
    }

    public void setActual(CustomTab tab) {
        if (tabs.contains(tab)) {
            if (actual != null) {
                actual.setContenidoVisible(false);
            }
            actual = tab;
            actual.setContenidoVisible(true);
        }
    }

    public Set<CustomTab> getTabs() { return tabs; }

    public void actualizarTabs(Object item) {
        tabs.forEach(t -> t.actualizar(item));
    }

    public int size() {
        return tabs.size();
    }

    public void iniciar(EModoVista modo, AbstractEntidad item) {
        tabs.forEach(t -> {
            t.getContenido().iniciar(modo, item);
            preformatearContenidoTab(t);
            divgroup.add(t.getContenido().getViewComponent());
        });
    }

    public void cerrar() {
        tabs.forEach(t -> t.getContenido().cerrar());
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        tabgroup.setVisible(visible);
        divgroup.setVisible(visible);
    }
}
