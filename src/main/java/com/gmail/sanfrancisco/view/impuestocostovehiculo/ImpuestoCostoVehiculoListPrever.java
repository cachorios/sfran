package com.gmail.sanfrancisco.view.impuestocostovehiculo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.ImpuestoCostoVehiculo;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ImpuestoCostoVehiculoListPrever extends AbstractPreview<ImpuestoCostoVehiculo> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), ImpuestoCostoVehiculo::getId));
        addItem("saldo", new PreviewItem<>(textField("Saldo"), ImpuestoCostoVehiculo::getSaldo));
    }
}