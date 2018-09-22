package com.gmail.cacho.slapi.view.interfaces;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.component.textfield.TextField;

/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un 'Layout' para un objeto presentable de
 * tipo 'listado' (ejemplo AbstractList) del sistema.
 *
 * @author larios
 * @version 20180201
 */
public interface ILayoutInnerList<T extends AbstractEntidad> extends ILayout {
    IPresentableList<T> getPresentable();

    void actualizarCantidadRegistros();

    H2 getTitulo();

    TextField getFiltro();

    HorizontalLayout getTopBar();

    ThemableLayout getContenido();

    Grid<T> getGrilla();

    HorizontalLayout getTopbar();

    HorizontalLayout getAreaFiltro();

    HorizontalLayout getPrebotones();

    HorizontalLayout getBotonera();

    HorizontalLayout getPosbotones();

    Button getVerButton();

    Button getNuevoButton();

    Button getEditarButton();

    Button getBorrarButton();
}
