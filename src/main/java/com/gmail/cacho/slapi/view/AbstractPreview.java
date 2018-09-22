package com.gmail.cacho.slapi.view;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.interfaces.IVisualizableReadOnly;
import com.gmail.cacho.slbase.logging.L;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * Esta clase es la implementación por defecto de la interfase IVisualizableReadOnly
 * e implementa un objeto presentable del sistema asociado a un esquema de formulario
 * de pre-visualización de registros asociados a un Entidad particular del Sistema.
 * NOTA: Este tipo de objeto visual SOLO puede abrirse en modo EModoVista.VER.
 *
 * @author larios
 * @version 20180201
 */
public abstract class AbstractPreview<T extends AbstractEntidad> extends VerticalLayout implements IVisualizableReadOnly<T> {
    private IVisualizable padre;
    private EModoVista modoVista;
    protected T registroPreview;

    private void generarVista() {
        setearEstiloGeneral();
        crearElementos();
    }

    private void setearEstiloGeneral() {
        this.setClassName("list-preview");

        this.setSizeFull();
        this.setWidth("400px");
        this.setVisible(true);
    }

    @Override
    public void setPadre(IVisualizable padre) {
        this.padre = padre;
    }

    @Override
    public IVisualizable getPadre() {
        return padre;
    }

    @Override
    public void iniciar(EModoVista modo, AbstractEntidad item) {
        L.info(C.MSG_ACC_INITPREVIEW, this.getClass().getSimpleName());
        modoVista = EModoVista.VER;
        generarVista();
    }

    @Override
    public EModoVista getModoVista() {
        return modoVista;
    }

    @Override
    public VerticalLayout getViewComponent() {
        return this;
    }

    @Override
    public void cerrar() { }
}
