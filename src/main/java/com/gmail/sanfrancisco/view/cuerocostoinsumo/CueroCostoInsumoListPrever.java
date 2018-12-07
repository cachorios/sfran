package com.gmail.sanfrancisco.view.cuerocostoinsumo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumo;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class CueroCostoInsumoListPrever extends AbstractPreview<CueroCostoInsumo> {

    @Override
    public void crearElementos() {
        addItem("insumo", new PreviewItem<>(textField("Insumo"), CueroCostoInsumo::getInsumo));
        addItem("cantidad", new PreviewItem<>(textField("Cantidad"), CueroCostoInsumo::getCantidad));
        addItem("precio", new PreviewItem<>(textField("Precio"), CueroCostoInsumo::getPrecio));
    }
}