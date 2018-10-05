package com.gmail.sanfrancisco.view.consignatario;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConsignatarioListPrever extends AbstractPreview<Consignatario> {



    @Override
    public void crearElementos() {

        addItem("id", new PreviewItem<>(textField("ID"), Consignatario::getId));
//        addItem("descripcion", new PreviewItem<>(textField("Descripcion"), Consignatario::getDescripcion));
        addItem("cuil", new PreviewItem<>(textField("CUIL"), Consignatario::getCuil));
        addItem("celular", new PreviewItem<>(textField("Nro.Cel."), Consignatario::getCelular));
        addItem("telefono", new PreviewItem<>(textField("Nro.Tel."), Consignatario::getTelefono));
        addItem("domicilio", new PreviewItem<>(textField("Domicilio"), Consignatario::getDomicilio));
        addItem("email", new PreviewItem<>(textField("eMail"), Consignatario::getEmail));

    }


}
