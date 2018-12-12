package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;

public class FaenaDetalleSuperior extends Div {
    private ParamCSComponent categoria;
    private TextField cantidad;
    private TextField faenado;
    private TextField diferencia;
    private TextField kgVivo;
    private TextField aFaenar;

    public FaenaDetalleSuperior(){
        add(categoria);
        add(cantidad);
        add(faenado);
        add(diferencia);
        add(kgVivo);
        add(aFaenar);
    }


}
