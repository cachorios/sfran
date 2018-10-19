package com.gmail.cacho.slapi.view.utils;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.function.ValueProvider;



public class ColumnList<T extends AbstractEntidad, S> {
    private ValueProvider<T, S> proveedor;
    private String titulo;
    private String propiedad;
    private boolean ordenable;
    private Renderer renderer;
    private String width;

    public ColumnList(ValueProvider<T, S> proveedor, String titulo, String propiedad, boolean ordenable) {
        this.proveedor = proveedor;
        this.titulo = titulo;
        this.propiedad = propiedad;
        this.ordenable = ordenable;
        this.width = "100px";
    }

    public ColumnList(ValueProvider<T, S> proveedor, String titulo, String propiedad, boolean ordenable, String with) {
        this(proveedor, titulo, propiedad, ordenable);
        this.width = with;
    }

    public ColumnList(ValueProvider<T, S> proveedor, String titulo, String propiedad, boolean ordenable, String with, String formato) {
        this(proveedor, titulo, propiedad, ordenable, with);
    }

    public ColumnList(Renderer renderer, String titulo, String propiedad, boolean ordenable) {
        this.renderer = renderer;
        this.titulo = titulo;
        this.propiedad = propiedad;
        this.ordenable = ordenable;
        this.width = "";
    }
    public ColumnList(Renderer renderer, String titulo, String propiedad, boolean ordenable, String with) {
        this.renderer = renderer;
        this.titulo = titulo;
        this.propiedad = propiedad;
        this.ordenable = ordenable;
        this.width = with;
    }

    public ValueProvider<T, S> getProveedor() {
        return proveedor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public boolean isOrdenable() {
        return ordenable;
    }

    public boolean tieneFormato()  { return (renderer != null); }

    public Renderer getRenderer() {
        return renderer;
    }

    public String getWidth() {
        return width;
    }
}
