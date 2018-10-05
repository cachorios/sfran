package com.gmail.sanfrancisco.view.dtedetalleinsumo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteDetalleInsumoListPrever extends AbstractPreview<DteDetalleInsumo> {
    TextField id;
    TextField cantidad;
    TextField precio;

    @Override
    public void crearElementos() {
        id          = textField("ID",       false);
        cantidad    = textField("Cantidad", false);
        precio      = textField("Precio",   false);

        add(id, cantidad, precio);
//                envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);
    }

    @Override
    public void actualizar(DteDetalleInsumo item) {
        setValor(id,        DteDetalleInsumo::getId);
        setValor(cantidad,  DteDetalleInsumo::getCantidad);
        setValor(precio,    DteDetalleInsumo::getPrecio);
    }
}
