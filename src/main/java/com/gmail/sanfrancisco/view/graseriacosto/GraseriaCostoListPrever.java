package com.gmail.sanfrancisco.view.graseriacosto;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.GraseriaCosto;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;

public class GraseriaCostoListPrever extends AbstractPreview<GraseriaCosto> {

    @Override
    public void crearElementos() {
        addItem("fecha", new PreviewItem<>(dateField("Fecha"), GraseriaCosto::getFecha));
    }
}
