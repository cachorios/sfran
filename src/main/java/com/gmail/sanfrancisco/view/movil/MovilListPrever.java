package com.gmail.sanfrancisco.view.movil;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class MovilListPrever extends AbstractPreview<Vehiculo> {
    TextField id;
    TextField dominio;
    TextField tipoMovil;
    TextField maxCabezas;
    TextField tipoCombustible;

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), Vehiculo::getId));
        addItem("dominio", new PreviewItem<>(textField("Dominio"), Vehiculo::getDominio));
        addItem("tipo de movil", new PreviewItem<>(textField("Tipo de movil"), Vehiculo::getTipoMovil));
        addItem("maximo de cabezas", new PreviewItem<>(textField("Maximo de cabezas"), Vehiculo::getMaxCabezas));
        addItem("tipo de combustible", new PreviewItem<>(textField("Tipo de combustible"), Vehiculo::getTipoCombustible));
    }

}
