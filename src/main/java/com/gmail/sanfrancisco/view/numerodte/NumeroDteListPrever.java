package com.gmail.sanfrancisco.view.numerodte;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.NumeroDte;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class NumeroDteListPrever extends AbstractPreview<NumeroDte> {

    @Override
    public void crearElementos() {
        addItem("Nro", new PreviewItem<>(textField("Descripción"), NumeroDte::getNumero));

    }
}
