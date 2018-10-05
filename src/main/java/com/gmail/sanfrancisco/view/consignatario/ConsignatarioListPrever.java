package com.gmail.sanfrancisco.view.consignatario;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConsignatarioListPrever extends AbstractPreview<Consignatario> {
<<<<<<< HEAD


    @Override
    public void crearElementos() {

        addItem("id", new PreviewItem<>(textField("ID"), Consignatario::getId));
        addItem("descripcion", new PreviewItem<>(textField("Descripcion"), Consignatario::getDescripcion));
        addItem("cuil", new PreviewItem<>(textField("CUIL"), Consignatario::getCuil));
        addItem("celular", new PreviewItem<>(textField("Nro.Cel."), Consignatario::getCelular));
        addItem("telefono", new PreviewItem<>(textField("Nro.Tel."), Consignatario::getTelefono));
        addItem("domicilio", new PreviewItem<>(textField("Domicilio"), Consignatario::getDomicilio));
        addItem("email", new PreviewItem<>(textField("eMail"), Consignatario::getEmail));

=======
    TextField id;
    TextField nombre;
    TextField apellido;
    TextField cuil;
    TextField celular;
    TextField telefono;
    TextField domicilio;
    TextField email;

    @Override
    public void crearElementos() {
        id          = textField("ID",false);
        nombre      = textField("Nombre",false);
        apellido    = textField("Apellido",false);
        cuil        = textField("CUIL",false);
        celular     = textField("Celular",false);
        telefono    = textField("Telefono",false);
        domicilio   = textField("Domicilio",false);
        email       = textField("Correo electronico",false);

        add(id, nombre, apellido, cuil, celular, telefono, domicilio, email);
        // envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);
    }

    @Override
    public void actualizar(Consignatario item) {
        setValor(id,            Consignatario::getId);
        setValor(nombre,        Consignatario::getNombre);
        setValor(apellido,      Consignatario::getApellido);
        setValor(cuil,          Consignatario::getCuil);
        setValor(celular,       Consignatario::getCelular);
        setValor(telefono,      Consignatario::getTelefono);
        setValor(domicilio,     Consignatario::getDomicilio);
        setValor(email,         Consignatario::getEmail);
>>>>>>> cd559ff18e123db64f17eb748218171ff519b0f7
    }


}
