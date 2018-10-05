package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.cacho.slapi.view.utils.ViewTools;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ComisionistaListPrever extends AbstractPreview<Comisionista> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), Comisionista::getId));
//        addItem("descripcion", new PreviewItem<>(textField("Descripción"), Comisionista::getDescripcion));
        addItem("cuil", new PreviewItem<>(textField("CUIL"), Comisionista::getCuil));
        addItem("celular", new PreviewItem<>(textField("Nro.Cel."), Comisionista::getCelular));
        addItem("telefono", new PreviewItem<>(textField("Nro.Tel."), Comisionista::getTelefono));
        addItem("domicilio", new PreviewItem<>(textField("Domicilio"), Comisionista::getDomicilio));
        addItem("celular", new PreviewItem<>(textField("Nro.Cle."), Comisionista::getCelular));
        addItem("saldo", new PreviewItem<>(textField("Saldo"), Comisionista::getSaldo));
        addItem("email", new PreviewItem<>(textField("Email"), Comisionista::getEmail));
    }



}
