package com.gmail.sanfrancisco.view.insumo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class InsumoListPrever extends AbstractPreview<Insumo> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), Insumo::getId));
        addItem("descripcion", new PreviewItem<>(textField("Descripción"), Insumo::getDescripcion));
        addItem("tipo de insumo", new PreviewItem<>(textField("Tipo de insumo"), Insumo::getTipoInsumo));
        addItem("unidad", new PreviewItem<>(textField("Unidad"), Insumo::getUnidadMedida));
    }
}
