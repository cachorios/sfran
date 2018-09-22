package com.gmail.cacho.slapi.view.customs.tabs;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.view.interfaces.ISolapable;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.view.excepciones.VistaErrorException;
import com.vaadin.flow.component.tabs.Tab;

public class CustomTab<T extends AbstractEntidad> extends Tab {
    private ISolapable<T> contenido;

    public CustomTab(String label, ISolapable<T> contenido) {
        super(label);
        if (contenido == null) {
            throw new VistaErrorException(Constantes.MSJ_ERR_TAB_WITHOUT_CONTENT, getClassName());
        }
        this.contenido = contenido;
        this.contenido.setTabPadre(this);
    }

    public ISolapable<T> getContenido() {
        return contenido;
    }

    public void setContenidoVisible(boolean visible) {
        contenido.getViewComponent().setVisible(visible);
    }

    public void actualizar(Object item) {
        contenido.actualizar(item);
    }
}
