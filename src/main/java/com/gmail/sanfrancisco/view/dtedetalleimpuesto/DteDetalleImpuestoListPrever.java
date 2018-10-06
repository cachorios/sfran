package com.gmail.sanfrancisco.view.dtedetalleimpuesto;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.DteDetalleImpuesto;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteDetalleImpuestoListPrever extends AbstractPreview<DteDetalleImpuesto> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), DteDetalleImpuesto::getId));
        addItem("saldo", new PreviewItem<>(textField("Saldo"), DteDetalleImpuesto::getSaldo));
    }

}