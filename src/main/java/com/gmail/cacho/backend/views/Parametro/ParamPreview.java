package com.gmail.cacho.backend.views.Parametro;


import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.TextField;

import java.time.ZoneId;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.espacio;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;


public class ParamPreview extends AbstractPreview<Parametro> {


    private TextField id;
    private TextField tipo;
    private TextField clase;
    private TextField orden;
    private TextField nombre;
    private TextField valorint;
    private TextField valordob;
    private TextField valorstr;
    private Checkbox valorbol;
    private DatePicker valordat;
    private TextField valorchr;

    @Override
    public void crearElementos() {
        id = textField("ID", false);
        tipo = textField(Parametro.F_PAR_TIPO, false);
        clase = textField(Parametro.F_PAR_CLASE, false);
        orden = textField(Parametro.F_PAR_ORDEN, false);
        nombre = textField(Parametro.F_PAR_NOMBRE, false);
        valorint = textField(Parametro.F_PAR_VALORINT, false);
        valordob = textField(Parametro.F_PAR_VALORDOB, false);
        valorstr = textField(Parametro.F_PAR_VALORSTR, false);
        valorchr = textField(Parametro.F_PAR_VALORCHR, false);

        valorbol = new Checkbox(Parametro.F_PAR_VALORBOL, false);
        valorbol.setEnabled(false);

        valordat = new DatePicker(Parametro.F_PAR_VALORDAT);
        //valordat.setDateFormat(C.SYS_APP_DATEFORMAT_VIEW);
        valordat.setEnabled(false);

        add(id, tipo, clase, orden, nombre, valorint, valordob,
                      envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);
    }

    @Override
    public void actualizar(Parametro item) {
        registroPreview = item;
    if (registroPreview != null) {

            id.setValue(registroPreview.getId() == null ? C.SYS_CAD_NULL : registroPreview.getId().toString());
            tipo.setValue(registroPreview.getTipo() == null ? C.SYS_CAD_NULL : registroPreview.getTipo().name());
            clase.setValue(registroPreview.getClase() == null ? C.SYS_CAD_NULL : registroPreview.getClase());
            orden.setValue(registroPreview.getOrden() == null ? C.SYS_CAD_NULL : registroPreview.getOrden().toString());
            nombre.setValue(registroPreview.getNombre() == null ? C.SYS_CAD_NULL : registroPreview.getNombre());
            valorint.setValue(registroPreview.getValorint() == null ? C.SYS_CAD_NULL : registroPreview.getValorint().toString());
            valordob.setValue(registroPreview.getValordob() == null ? C.SYS_CAD_NULL : registroPreview.getValordob().toString());
            valorchr.setValue(registroPreview.getValorchr() == null ? C.SYS_CAD_NULL : registroPreview.getValorchr().toString());
            valorstr.setValue(registroPreview.getValorstr() == null ? C.SYS_CAD_NULL : registroPreview.getValorstr());
            valordat.setValue(registroPreview.getValordat() == null ? null : registroPreview.getValordat().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            valorbol.setValue(registroPreview.getValorbol());
        } else {
            id.setValue(C.SYS_CAD_NULL);
            tipo.setValue(C.SYS_CAD_NULL);
            clase.setValue(C.SYS_CAD_NULL);
            orden.setValue(C.SYS_CAD_NULL);
            nombre.setValue(C.SYS_CAD_NULL);
            valorint.setValue(C.SYS_CAD_NULL);
            valordob.setValue(C.SYS_CAD_NULL);
            valorchr.setValue(C.SYS_CAD_NULL);
            valorstr.setValue(C.SYS_CAD_NULL);
            valordat.setValue(null);
            valorbol.setValue(false);
        }
    }


}
