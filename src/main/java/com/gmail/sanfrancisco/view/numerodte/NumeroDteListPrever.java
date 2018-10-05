package com.gmail.sanfrancisco.view.numerodte;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.sanfrancisco.entidad.NumeroDte;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class NumeroDteListPrever extends AbstractPreview<NumeroDte> {
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
    public void actualizar(NumeroDte item) {
        setValor(id,            NumeroDte::getId);
        setValor(descripcion,   NumeroDte::getDescripcion);
    }
}
