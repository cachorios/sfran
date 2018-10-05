package com.gmail.sanfrancisco.view.productor;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.sanfrancisco.entidad.Productor;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ProductorListPrever extends AbstractPreview<Productor> {
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
    public void actualizar(Productor item) {
        setValor(id,            Productor::getId);
        setValor(nombre,        Productor::getNombre);
        setValor(apellido,      Productor::getApellido);
        setValor(cuil,          Productor::getCuil);
        setValor(celular,       Productor::getCelular);
        setValor(telefono,      Productor::getTelefono);
        setValor(domicilio,     Productor::getDomicilio);
        setValor(email,         Productor::getEmail);
    }
}
