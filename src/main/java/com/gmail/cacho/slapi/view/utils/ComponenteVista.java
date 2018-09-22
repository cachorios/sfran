package com.gmail.cacho.slapi.view.utils;


import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;

import java.util.List;

public class ComponenteVista {
    private Button componente;
    private List<EModoVista> modos;
    private boolean conform, consel;
    private ComponentEventListener<ClickEvent<Button>> cl;
    private Key shortcut;

    public ComponenteVista(Button componente, List<EModoVista> modos, boolean conform, boolean consel,
                           Key shortcut,  ComponentEventListener<ClickEvent<Button>> cl) {
        this.componente = componente;
        this.modos = modos;
        this.conform = conform;
        this.consel = consel;
        this.cl = cl;
        this.shortcut = shortcut;

    }

    public Button getComponente() {
        return componente;
    }

    public List<EModoVista> getModosVista() {
        return modos;
    }

    public boolean conForm() {
        return conform;
    }

    public boolean conSel() {
        return consel;
    }

    public Key getShortcut() {
        return shortcut;
    }

    public  ComponentEventListener<ClickEvent<Button>> getCl() {
        return cl;
    }
}
