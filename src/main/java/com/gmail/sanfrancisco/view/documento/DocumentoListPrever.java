package com.gmail.sanfrancisco.view.documento;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Documento;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DocumentoListPrever extends AbstractPreview<Documento> {

    @Override
    public void crearElementos() {
        addItem("nombre de archivo", new PreviewItem<>(textField("Nombre de archivo"), Documento::getNombreArchivo));
        addItem("descripción", new PreviewItem<>(textField("Descripción"), Documento::getDescripcion));
    }
}
