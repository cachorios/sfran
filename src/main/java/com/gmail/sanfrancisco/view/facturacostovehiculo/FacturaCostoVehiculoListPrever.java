package com.gmail.sanfrancisco.view.facturacostovehiculo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.FacturaCostoVehiculo;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FacturaCostoVehiculoListPrever extends AbstractPreview<FacturaCostoVehiculo> {

    @Override
    public void crearElementos() {
        addItem("nombre", new PreviewItem<>(textField("Nombre"), FacturaCostoVehiculo::getFecha));
    }
}
