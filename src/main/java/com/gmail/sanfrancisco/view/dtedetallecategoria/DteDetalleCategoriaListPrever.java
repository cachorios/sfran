package com.gmail.sanfrancisco.view.dtedetallecategoria;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteDetalleCategoriaListPrever extends AbstractPreview<DteDetalleCategoria> {

    @Override
    public void crearElementos() {

        addItem("categoria", new PreviewItem<>(textField("Categoria"), DteDetalleCategoria::getCategoria));
        addItem("cantidad", new PreviewItem<>(textField("Cantidad"), DteDetalleCategoria::getCantidad));
        addItem("kilogramos vivos", new PreviewItem<>(textField("Kilogramos vivos"), DteDetalleCategoria::getKgVivo));
        addItem("precio por kg vivo", new PreviewItem<>(textField("Precio por kg vivos"), DteDetalleCategoria::getPrecioKgVivo));
        addItem("kilogramos de carne", new PreviewItem<>(textField("Kilogramos de carne"), DteDetalleCategoria::getKgCarne));
        addItem("porcentaje de comision", new PreviewItem<>(textField("Porcentaje de comision"), DteDetalleCategoria::getPorcentajeComision));
    }

}