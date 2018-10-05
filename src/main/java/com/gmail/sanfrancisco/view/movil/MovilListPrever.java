package com.gmail.sanfrancisco.view.movil;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Movil;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class MovilListPrever extends AbstractPreview<Movil> {
    TextField id;
    TextField dominio;
    TextField tipoMovil;
    TextField maxCabezas;
    TextField tipoCombustible;

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), Movil::getId));
        addItem("dominio", new PreviewItem<>(textField("Dominio"), Movil::getDominio));
        addItem("tipo de movil", new PreviewItem<>(textField("Tipo de movil"), Movil::getTipoMovil));
        addItem("maximo de cabezas", new PreviewItem<>(textField("Maximo de cabezas"), Movil::getMaxCabezas));
        addItem("tipo de combustible", new PreviewItem<>(textField("Tipo de combustible"), Movil::getTipoCombustible));
    }

}
