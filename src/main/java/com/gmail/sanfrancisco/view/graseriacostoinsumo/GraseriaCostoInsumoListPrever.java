package com.gmail.sanfrancisco.view.graseriacostoinsumo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumo;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class GraseriaCostoInsumoListPrever extends AbstractPreview<GraseriaCostoInsumo> {

    @Override
    public void crearElementos() {
        addItem("insumo", new PreviewItem<>(textField("Insumo"), GraseriaCostoInsumo::getInsumo));
        addItem("cantidad", new PreviewItem<>(textField("Cantidad"), GraseriaCostoInsumo::getCantidad));
        addItem("precio", new PreviewItem<>(textField("Precio"), GraseriaCostoInsumo::getPrecio));
    }
}