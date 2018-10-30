package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Dte;


import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteListPrever extends AbstractPreview<Dte> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), Dte::getId));
        addItem("numerotropa", new PreviewItem<>(textField("Numero tropa"), Dte::getNumeroTropa));
        addItem("origen", new PreviewItem<>(textField("Origen"), Dte::getLocalidadOrigen));
        addItem("destino", new PreviewItem<>(textField("Destino"), Dte::getLocalidadDestino));
        addItem("entrega en efectivo", new PreviewItem<>(textField("Entrega en efectivo"), Dte::getImporteEntrega));
        addItem("ajustes", new PreviewItem<>(textField("Ajustes"), Dte::getAjustes));
    }
}