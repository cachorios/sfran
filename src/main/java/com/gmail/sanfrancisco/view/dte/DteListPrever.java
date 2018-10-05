package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.sanfrancisco.entidad.Dte;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteListPrever extends AbstractPreview<Dte> {
    TextField id;
    TextField numTropa;
    TextField origen;
    TextField destino;
    TextField entrega;
    TextField ajustes;

    @Override
    public void crearElementos() {
        id          = textField("ID",       false);
        numTropa    = textField("Numero de tropa", false);
        origen      = textField("Origen", false);
        destino     = textField("Destino", false);
        entrega     = textField("Entrega en efectivo", false);
        ajustes     = textField("Ajustes", false);


        add(id, numTropa, origen, destino, entrega, ajustes);
//                envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);
    }


}