package com.gmail.sanfrancisco.view.renspa;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class RenspaListPrever extends AbstractPreview<Renspa> {
    TextField id;
    TextField descripcion;

    @Override
    public void crearElementos() {
        id              = textField("ID", false);
        descripcion     = textField("Descripción", false);

        add(id, descripcion);
//                envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);
    }

    @Override
    public void actualizar(Renspa item) {
        setValor(id,            Renspa::getId);
        setValor(descripcion,   Renspa::getDescripcion);
    }
}
