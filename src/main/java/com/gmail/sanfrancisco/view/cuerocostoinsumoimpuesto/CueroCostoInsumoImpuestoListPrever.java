package com.gmail.sanfrancisco.view.cuerocostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumoImpuesto;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;

public class CueroCostoInsumoImpuestoListPrever extends AbstractPreview<CueroCostoInsumoImpuesto> {

    @Override
    public void crearElementos() {
        addItem("saldo", new PreviewItem<>(dateField("Saldo"), CueroCostoInsumoImpuesto::getSaldo));
    }
}
