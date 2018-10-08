package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConductorListPrever extends AbstractPreview<Conductor> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), Conductor::getId));
        addItem("apellido", new PreviewItem<>(textField("Apellido"), Conductor::getApellido));
        addItem("nombre", new PreviewItem<>(textField("Nombre"), Conductor::getNombre));
        addItem("telefono", new PreviewItem<>(textField("Nro.Tel."), Conductor::getTelefono));
        addItem("Operadora", new PreviewItem<>(textField("Operadora telefonica"), Conductor::getOperadoraTelefonica));
        addItem("Celular", new PreviewItem<>(textField("Nro.Cel."), Conductor::getCelular));
    }
}
