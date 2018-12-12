package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.sanfrancisco.entidad.Faena;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FaenaDetalleSuperior extends Div {
    private ParamCSComponent categoria;
    private TextField cantidad;
    private TextField faenado;
    private TextField diferencia;
    private TextField kgVivo;
    private TextField aFaenar;

    public FaenaDetalleSuperior(){
        setWidth("800px");
        //categoria = new ParamCSComponent("Categoria", ((DefaultInnerDialog<>)this.getParent()).getPresentable(), true, true, "Categorias", ETipoParametro.CATEGORIA_ANIMAL);
        cantidad = textField("Cantidad", "12%");
        faenado = textField("Faenado", "12%");
        diferencia = textField("diferencia", "12%");
        kgVivo = textField("Kilogramos vivos", "12%");
        aFaenar = textField("A Faenar", "12%");

        /*add(
                //envolver(categoria, "30%"),
                envolver(cantidad),
                envolver(faenado),
                envolver(diferencia),
                envolver(kgVivo),
                envolver(aFaenar)
        );*/

        add(cantidad);
        add(faenado);
        add(diferencia);
        add(kgVivo);
        add(aFaenar);
    }


}
