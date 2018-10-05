package com.gmail.cacho.backend.views.parametro;


import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.cacho.slapi.view.utils.ViewTools;
import com.gmail.cacho.slbase.core.Constantes;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ParamPreview extends AbstractPreview<Parametro> {

    @Override
    public void crearElementos() {
        addItem("nombre", new PreviewItem<>(textField(Parametro.F_PAR_NOMBRE), Parametro::getNombre));
        addItem("valorint", new PreviewItem<>(textField(Parametro.F_PAR_VALORINT), Parametro::getValorint));
        addItem("valordob", new PreviewItem<>(textField(Parametro.F_PAR_VALORDOB), Parametro::getValordob));
        addItem("valordat", new PreviewItem<>(new DatePicker(Parametro.F_PAR_VALORDAT), Parametro::getValordat, ViewTools::envolver));
        addItem("valorstr", new PreviewItem<>(textField(Parametro.F_PAR_VALORSTR), Parametro::getValorstr));
        addItem("valorchr", new PreviewItem<>(textField(Parametro.F_PAR_VALORCHR), Parametro::getValorchr));
        addItem("espacio", new PreviewItem<>(textField(Constantes.SYS_CAD_NULL), null));
        addItem("valorbol", new PreviewItem<>(new Checkbox(Parametro.F_PAR_VALORBOL), Parametro::getValorbol));
    }

}
