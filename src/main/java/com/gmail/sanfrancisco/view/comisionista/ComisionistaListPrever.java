package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.ViewTools;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ComisionistaListPrever extends AbstractPreview<Comisionista> {
    TextField id;
    TextField nombre;
    TextField apellido;
    TextField cuil;
    TextField celular;
    TextField telefono;
    TextField domicilio;
    TextField saldo;
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
        saldo       = textField("Saldo",false);
        email       = textField("Correo electronico",false);

        add(id, nombre, apellido, cuil, celular, telefono, domicilio, saldo, email);
                // envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);
    }

    @Override
    public void actualizar(Comisionista item) {
        setValor(id,            Comisionista::getId);
        setValor(nombre,        Comisionista::getNombre);
        setValor(apellido,      Comisionista::getApellido);
        setValor(cuil,          Comisionista::getCuil);
        setValor(celular,       Comisionista::getCelular);
        setValor(telefono,      Comisionista::getTelefono);
        setValor(domicilio,     Comisionista::getDomicilio);
        setValor(saldo,         Comisionista::getSaldo);
        setValor(email,         Comisionista::getEmail);
    }
}
