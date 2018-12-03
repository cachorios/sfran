package com.gmail.sanfrancisco.view.vehiculocostoinsumo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumo;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class VehiculoCostoInsumoListPrever extends AbstractPreview<VehiculoCostoInsumo> {

    @Override
    public void crearElementos() {
        addItem("cantidad", new PreviewItem<>(textField("Cantidad"), VehiculoCostoInsumo::getCantidad));
        addItem("precio", new PreviewItem<>(textField("Precio"), VehiculoCostoInsumo::getPrecio));
    }
}