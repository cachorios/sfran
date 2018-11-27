package com.gmail.sanfrancisco.view.graseriadetalleimpuesto;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleImpuesto;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;

public class GraseriaDetalleImpuestoListPrever extends AbstractPreview<GraseriaDetalleImpuesto> {

    @Override
    public void crearElementos() {
        addItem("saldo", new PreviewItem<>(dateField("Saldo"), GraseriaDetalleImpuesto::getSaldo));
    }
}
