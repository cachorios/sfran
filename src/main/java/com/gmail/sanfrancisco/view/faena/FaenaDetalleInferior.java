package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.sanfrancisco.view.dte.DteCS;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;

public class FaenaDetalleInferior extends Div {
    private DteCS dteCSDetalle;
    private TextField orden;
    private ParamCSComponent categoriaDetalle;
    private TextField kgIzquierdo;
    private TextField kgDerecho;

    public FaenaDetalleInferior() {
        add(dteCSDetalle);
        add(orden);
        add(categoriaDetalle);
        add(kgIzquierdo);
        add(kgDerecho);
    }
}
