package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.slapi.view.customs.tabs.CustomTabGroup;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.button.Button;

/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un 'Layout' para un objeto visuatable de
 * panel de trabajo (ejemplo AbstractPanel) del sistema.
 *
 * @author larios
 * @version 20180201
 */
public interface ILayoutInner extends ILayout {
    Component getLayout();

    Component getContenido();

    CustomTabGroup getTabs();

    Button getGuardarButton();

    Button getCancelarButton();

    Focusable getPrimerElementoForm();

    void setEditableState(boolean enable);
}
