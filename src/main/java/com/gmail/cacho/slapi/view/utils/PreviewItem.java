package com.gmail.cacho.slapi.view.utils;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.function.ValueProvider;

public class PreviewItem<T extends AbstractEntidad, V> {
    private AbstractField item;
    private ValueProvider<T, V> proveedor;
    private ValueProvider<Component, Component> mascara;

    public PreviewItem(AbstractField item, ValueProvider<T, V> proveedor, boolean enable, ValueProvider<Component, Component> mascara) {
        this.item = item;
        this.proveedor = proveedor;
        this.mascara = mascara;
        item.setEnabled(enable);
    }

    public PreviewItem(AbstractField item, ValueProvider<T, V> proveedor, boolean enable) {
        this(item, proveedor, enable, (i) -> i);
    }

    public PreviewItem(AbstractField item, ValueProvider<T, V> proveedor, ValueProvider<Component, Component> mascara) {
        this(item, proveedor, false, mascara);
    }

    public PreviewItem(AbstractField item, ValueProvider<T, V> proveedor) {
        this(item, proveedor, false, (i) -> i);
    }

    public AbstractField getItem() {
        return item;
    }

    public ValueProvider<T, V> getProveedor() {
        return proveedor;
    }

    public ValueProvider<Component, Component> getMascara() {
        return mascara;
    }
}
