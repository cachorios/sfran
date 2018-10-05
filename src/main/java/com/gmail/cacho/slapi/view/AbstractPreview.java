package com.gmail.cacho.slapi.view;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.interfaces.IVisualizableReadOnly;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.logging.L;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.function.ValueProvider;

import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.gmail.cacho.slapi.view.utils.ViewTools.espacio;

/**
 * Esta clase es la implementación por defecto de la interfase IVisualizableReadOnly
 * e implementa un objeto presentable del sistema asociado a un esquema de formulario
 * de pre-visualización de registros asociados a un Entidad particular del Sistema.
 * NOTA: Este tipo de objeto visual SOLO puede abrirse en modo EModoVista.VER.
 *
 * @author larios
 * @version 20180201
 */
public abstract class AbstractPreview<T extends AbstractEntidad> extends Div implements IVisualizableReadOnly<T> {
    private IVisualizable padre;
    private EModoVista modoVista;
    private Map<String, PreviewItem> items = new LinkedHashMap<>();
    protected T registroPreview;

    private void generarVista() {
        setearEstiloGeneral();
        crearElementos();
        colocarElementos();
        posGenerarVista();
    }

    private void setearEstiloGeneral() {
//        this.setClassName("list-preview");

        this.setSizeFull();
        this.setVisible(true);
    }

    private void colocarElementos() {
        items.forEach(this::accept);
    }

    private void accept(String k, PreviewItem i) {
        if (i.getProveedor() == null) {
            add((Component) i.getMascara().apply(espacio()));
        } else {
            add((Component) i.getMascara().apply(i.getItem()));
        }
    }

    protected void posGenerarVista() {}

    protected void establecerEstadoInicial() {}

    private <V> void setValor(AbstractField c, ValueProvider<T, V> proveedor) {
        if (proveedor != null) {
            V ret;

            if (registroPreview == null) {
                if (c instanceof TextField) {
                    c.setValue(Constantes.SYS_CAD_NULL);
                } else if (c instanceof Checkbox) {
                    c.setValue(false);
                } else if (c instanceof DatePicker) {
                    c.setValue(null);
                }
            } else {
                ret = proveedor.apply(registroPreview);
                if (ret == null) {
                    if (c instanceof TextField) {
                        c.setValue(Constantes.SYS_CAD_NULL);
                    } else if (c instanceof Checkbox) {
                        c.setValue(false);
                    } else if (c instanceof DatePicker)
                        c.setValue(null);
                } else {
                    if (c instanceof TextField) {
                        c.setValue(ret.toString());
                    } else if (c instanceof Checkbox) {
                        c.setValue(ret);
                    } else if (c instanceof DatePicker)
                        c.setValue(((Date) ret).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                }
            }
        }
    }

    public void addItem(String nombre, PreviewItem item) {
        items.put(nombre, item);
    }

    public Map<String, PreviewItem> getItems() {
        return items;
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
        establecerEstadoInicial();
    }

    @Override
    public EModoVista getModoVista() {
        return modoVista;
    }

    @Override
    public Component getViewComponent() {
        return this;
    }

    @Override
    public void actualizar(T item) {
        registroPreview = item;
        items.forEach((k, i) -> setValor(i.getItem(), i.getProveedor()));
    }

    @Override
    public void cerrar() { }
}
