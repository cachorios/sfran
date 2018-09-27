package com.gmail.sanfrancisco.view.insumo;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class InsumoListPrever extends AbstractPreview<Insumo> {
    TextField id;
    TextField descripcion;
    TextField tipoInsumo;
    TextField unidad;

    @Override
    public void crearElementos() {
        id          = textField("ID", false);
        descripcion = textField("Descripción",false);
        tipoInsumo  = textField("Tipo insumo", false);
        unidad      = textField("Unidad", false);

        add(id, descripcion, tipoInsumo,unidad);
                // envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);
    }

    @Override
    public void actualizar(Insumo item) {
        setValor(id,            Insumo::getId);
        setValor(descripcion,   Insumo::getDescripcion);
        setValor(tipoInsumo,    Insumo::getTipoInsumo);
        setValor(unidad,        Insumo::getUnidad);
    }
}
