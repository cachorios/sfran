package com.gmail.sanfrancisco.view.dtedetalleinsumo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteDetalleInsumoListPrever extends AbstractPreview<DteDetalleInsumo> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), DteDetalleInsumo::getId));
        addItem("cantidad", new PreviewItem<>(textField("Cantidad"), DteDetalleInsumo::getCantidad));
        addItem("precio", new PreviewItem<>(textField("Precio"), DteDetalleInsumo::getPrecio));
    }

}
