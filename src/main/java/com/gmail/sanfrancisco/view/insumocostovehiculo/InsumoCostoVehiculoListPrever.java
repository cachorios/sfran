package com.gmail.sanfrancisco.view.insumocostovehiculo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class InsumoCostoVehiculoListPrever extends AbstractPreview<InsumoCostoVehiculo> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), InsumoCostoVehiculo::getId));
        addItem("cantidad", new PreviewItem<>(textField("Cantidad"), InsumoCostoVehiculo::getCantidad));
        addItem("precio", new PreviewItem<>(textField("Precio"), InsumoCostoVehiculo::getPrecio));
    }
}