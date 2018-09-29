package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConductorListPrever extends AbstractPreview<Conductor> {
    TextField id;
    TextField apellido;
    TextField nombre;
    TextField telefono;
    TextField celular;

    @Override
    public void crearElementos() {
        id          = textField("ID",       false);
        apellido    = textField("Apelldio", false);
        nombre      = textField("Apelldio", false);
        telefono    = textField("Telefono", false);
        celular     = textField("Celular", false);

        add(id, apellido, nombre, telefono, celular);
//                envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);


    }

    @Override
    public void actualizar(Conductor item) {
        setValor(id,        Conductor::getId);
        setValor(apellido,  Conductor::getApellido);
        setValor(nombre,    Conductor::getNombre);
        setValor(telefono,  Conductor::getTelefono);
        setValor(celular,   Conductor::getCelular);
    }
}
