package com.gmail.sanfrancisco.view.movil;

import com.gmail.cacho.slapi.view.AbstractPreview;
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
        id              = textField("ID", false);
        dominio         = textField("Dominio",false);
        tipoMovil       = textField("Tipo de movil", false);
        maxCabezas      = textField("Maximo de cabezas", false);
        tipoCombustible = textField("Tipo de combustible", false);

        add(id, dominio, tipoMovil, maxCabezas, tipoCombustible);
//                envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);
    }

    @Override
    public void actualizar(Movil item) {
        setValor(id,                Movil::getId);
        setValor(dominio,           Movil::getDominio);
        setValor(tipoMovil,         Movil::getTipoMovil);
        setValor(maxCabezas,        Movil::getMaxCabezas);
        setValor(tipoCombustible,   Movil::getTipoCombustible);
    }
}
