package com.gmail.sanfrancisco.view.vehiculocosto;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.VehiculoCosto;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class VehiculoCostoListPrever extends AbstractPreview<VehiculoCosto> {

    @Override
    public void crearElementos() {
        addItem("fecha", new PreviewItem<>(dateField("Fecha"), VehiculoCosto::getFecha));
    }
}
