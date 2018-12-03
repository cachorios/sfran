package com.gmail.sanfrancisco.view.vehiculocostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumoImpuesto;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class VehiculoCostoInsumoImpuestoListPrever extends AbstractPreview<VehiculoCostoInsumoImpuesto> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), VehiculoCostoInsumoImpuesto::getId));
        addItem("saldo", new PreviewItem<>(textField("Saldo"), VehiculoCostoInsumoImpuesto::getSaldo));
    }
}