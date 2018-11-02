package com.gmail.sanfrancisco.view.renspa;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class RenspaListPrever extends AbstractPreview<Renspa> {
    TextField id;
    TextField descripcion;

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"),Renspa::getId));
        addItem("id", new PreviewItem<>(textField("Numero renspa"),Renspa::getNumeroRenspa));
    }
}
