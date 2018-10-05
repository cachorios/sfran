package com.gmail.cacho.slapi.view.customs.tabs;


import com.gmail.cacho.slapi.view.interfaces.ITabeable;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.view.excepciones.VistaErrorException;
import com.vaadin.flow.component.tabs.Tab;

public class CustomTab extends Tab {
    private ITabeable contenido;

    public CustomTab(String label, ITabeable contenido) {
        super(label);
        if (contenido == null) {
            throw new VistaErrorException(Constantes.MSJ_ERR_TAB_WITHOUT_CONTENT, getClassName());
        }
        this.contenido = contenido;
        this.contenido.setTabpadre(this);
    }

    public ITabeable getContenido() {
        return contenido;
    }

    public void setContenidoVisible(boolean visible) {
        contenido.setVisible(visible);
    }

    public void actualizar(Object item) {
        contenido.actualizar(item);
    }
}
