package com.gmail.sanfrancisco.view.graseriadetalleinsumo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleInsumo;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class GraseriaDetalleInsumoListPrever extends AbstractPreview<GraseriaDetalleInsumo> {

    @Override
    public void crearElementos() {
        addItem("insumo", new PreviewItem<>(textField("Insumo"), GraseriaDetalleInsumo::getInsumo));
        addItem("cantidad", new PreviewItem<>(textField("Cantidad"), GraseriaDetalleInsumo::getCantidad));
        addItem("precio", new PreviewItem<>(textField("Precio"), GraseriaDetalleInsumo::getPrecio));
    }
}