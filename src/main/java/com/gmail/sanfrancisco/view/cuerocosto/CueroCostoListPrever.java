package com.gmail.sanfrancisco.view.cuerocosto;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.CueroCosto;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;

public class CueroCostoListPrever extends AbstractPreview<CueroCosto> {

    @Override
    public void crearElementos() {
        addItem("fecha", new PreviewItem<>(dateField("Fecha"), CueroCosto::getFecha));
    }
}