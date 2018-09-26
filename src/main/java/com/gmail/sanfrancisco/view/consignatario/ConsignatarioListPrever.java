package com.gmail.sanfrancisco.view.consignatario;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConsignatarioListPrever extends AbstractPreview<Consignatario> {
    TextField id;
    TextField descripcion;
    TextField cuil;
    TextField celular;
    TextField telefono;
    TextField domicilio;
    TextField email;

    @Override
    public void crearElementos() {
        id          = textField("ID",false);
        descripcion = textField("Descripción",false);
        cuil        = textField("CUIL",false);
        celular     = textField("Celular",false);
        telefono    = textField("Telefono",false);
        domicilio   = textField("Domicilio",false);
        email       = textField("Correo electronico",false);

        add(id, descripcion, cuil, celular, telefono, domicilio, email);
        // envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);
    }

    @Override
    public void actualizar(Consignatario item) {
        setValor(id,            Consignatario::getId);
        setValor(descripcion,   Consignatario::getDescripcion);
        setValor(cuil,          Consignatario::getCuil);
        setValor(celular,       Consignatario::getCelular);
        setValor(telefono,      Consignatario::getTelefono);
        setValor(domicilio,     Consignatario::getDomicilio);
        setValor(email,         Consignatario::getEmail);
    }
}
