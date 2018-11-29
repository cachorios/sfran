package com.gmail.sanfrancisco.view.graseria;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Graseria;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;

public class GraseriaListPrever extends AbstractPreview<Graseria> {

    @Override
    public void crearElementos() {
        addItem("fecha", new PreviewItem<>(dateField("Fecha"), Graseria::getFecha));
    }
}
