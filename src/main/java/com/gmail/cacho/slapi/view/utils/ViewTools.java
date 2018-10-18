package com.gmail.cacho.slapi.view.utils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;


/**
 * Esta es una clase en la que se espera se coloquen todos los metodos de
 * menor importancia relativos a la presentación de elementos en vistas del
 * Sistema. La idea es que sean metodos estáticos deterministas (que solo
 * dependan de sus parametros).
 *
 * @author cachorios-jmfragueiro
 * @version 20180204
 */
public class ViewTools {
    public static final String ALTO_DEFAULT = "100%";

    public static Component envolver(Component c) {
        return envolver(c, "100%");
    }

    public static Component envolver(Component c, String ancho) {
        Div layout = new Div(c);
        layout.addClassName("envolver");
        layout.setWidth(ancho);
        return layout;
    }

    public static TextField textField(String caption) {
        return textField(caption, true);
    }

    public static TextField textField(String caption, boolean enabled) {
        return textField(caption, enabled, "100%", ALTO_DEFAULT);
    }

    public static TextField textField(String caption, String ancho) {
        return textField(caption, true, ancho, ALTO_DEFAULT);
    }

    public static TextField textField(String caption, boolean enabled, String ancho) {
        return textField(caption, enabled, ancho, ALTO_DEFAULT);
    }

    public static TextField textField(String caption, boolean enabled, String ancho, String alto) {
        TextField t = new TextField(caption);
        t.setWidth(ancho);
        t.setEnabled(enabled);
        //t.setHeight(alto);
        t.setClassName("text");

        return t;
    }

    public static DatePicker dateField(String caption) {
        return dateField(caption, "100%");
    }

    public static DatePicker dateField(String caption, String ancho) {
        DatePicker fecha;
        fecha = new DatePicker(caption);
        fecha.setWidth("100%");
        //fecha.setHeight(ALTO_DEFAULT);

        //fecha.setLocale(Locale.CANADA);                //setDateFormat(C.SYS_APP_VIEW_DATEFORMAT);
        fecha.addValueChangeListener(v -> fecha.focus());

        return fecha;
    }

    public static Label espacio() {
        Label t = new Label("");
        t.setWidth("100%");
        t.getStyle().set("display", "inline-flex");

        return t;
    }

    public static Label generarTituloSeccion(String titulo) {
        Label label = new Label(titulo);
        label.setClassName("seccion");
//        label.setWidth("100%");
//                getElement().getStyle().set("width", "100%");
        //label.getElement().getStyle().set("display", "inline-flex");

        //                setWidth("100%");
        return label;
    }

    public static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
