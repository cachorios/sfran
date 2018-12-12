package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.cacho.slapi.view.interfaces.IPresentable;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.Faena;
import com.gmail.sanfrancisco.view.dte.DteCS;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FaenaDetalleInferior extends Div {
    private DteCS dteCSDetalle;
    private TextField orden;
    private ParamCSComponent categoriaDetalle;
    private TextField kgIzquierdo;
    private TextField kgDerecho;

    public FaenaDetalleInferior() {
        //dteCSDetalle = new DteCS("Tropa", (IPresentable<Faena>)this.getParent()).getPresentable(), true, true, true);

        orden = textField("Cantidad");
        //categoriaDetalle = new ParamCSComponent("Categoria", ((DefaultInnerDialog<>)this.getParent()).getPresentable(), true, true, "Categorias", ETipoParametro.CATEGORIA_ANIMAL);
        kgIzquierdo = textField("Kilogramos izquierdo");
        kgDerecho = textField("Kilogramos derecho");

        /*add(
                envolver(dteCSDetalle, "30%"),
                envolver(orden, "11%"),
                envolver(categoriaDetalle, "30%"),
                envolver(kgIzquierdo, "11%"),
                envolver(kgDerecho, "10%")
        );*/

        //add(dteCSDetalle, "30%");
        add(orden);
        //add(categoriaDetalle, "30%");
        add(kgIzquierdo);
        add(kgDerecho);
    }
}
