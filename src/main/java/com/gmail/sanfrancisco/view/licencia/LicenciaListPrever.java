package com.gmail.sanfrancisco.view.licencia;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class LicenciaListPrever extends AbstractPreview<Licencia> {
    TextField id;
    TextField tipoLicencia;
    DatePicker vencimiento;
    DatePicker vencimientoNac;
    DatePicker vencimientoCurso;
    Checkbox licenciaCarga;

    @Override
    public void crearElementos() {

        id               = textField("ID",       false);
        tipoLicencia     = textField("Tipo licencia", false);
        vencimiento      = dateField("Vencimiento", "50%");
        vencimientoNac   = dateField("Vencimiento Nac", "50%");
        vencimientoCurso = dateField("Vencimiento Curso", "50%");
        licenciaCarga    = new Checkbox("Habilitado para carga");
        licenciaCarga.setEnabled(false);

        add(id, tipoLicencia, vencimiento, vencimientoNac, vencimientoCurso, licenciaCarga);
//                envolver(valordat), valorchr, valorstr, envolver(espacio()), valorbol);
    }


}
