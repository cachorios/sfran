package com.gmail.sanfrancisco.view.productor;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Productor;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ProductorListPrever extends AbstractPreview<Productor> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"),Productor::getId));
        addItem("nombre", new PreviewItem<>(textField("Nombre"),Productor::getNombre));
        addItem("apellido", new PreviewItem<>(textField("Apellido"),Productor::getApellido));
        addItem("cuil", new PreviewItem<>(textField("CUIL"),Productor::getCuil));
        addItem("celular", new PreviewItem<>(textField("Nro. Cel."),Productor::getCelular));
        addItem("telefono", new PreviewItem<>(textField("Nro.Tel"),Productor::getTelefono));
        addItem("domicilio", new PreviewItem<>(textField("Domicilio"),Productor::getDomicilio));
        addItem("email", new PreviewItem<>(textField("eMail"),Productor::getEmail));

   }


}
