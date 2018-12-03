package com.gmail.sanfrancisco.view.graseriacostoinsumoimpuesto;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumoImpuesto;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;

public class GraseriaCostoInsumoImpuestoListPrever extends AbstractPreview<GraseriaCostoInsumoImpuesto> {

    @Override
    public void crearElementos() {
        addItem("saldo", new PreviewItem<>(dateField("Saldo"), GraseriaCostoInsumoImpuesto::getSaldo));
    }
}
