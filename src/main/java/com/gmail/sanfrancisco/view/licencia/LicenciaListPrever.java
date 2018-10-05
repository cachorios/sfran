package com.gmail.sanfrancisco.view.licencia;

import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.TextField;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class LicenciaListPrever extends AbstractPreview<Licencia> {

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), Licencia::getId));
        addItem("tipo de licencia", new PreviewItem<>(textField("Tipo de licencia"), Licencia::getTipoLicencia));
        addItem("vencimiento", new PreviewItem<>(dateField("Vencimiento"), Licencia::getVencimiento));
        addItem("venimiento del carnet", new PreviewItem<>(dateField("Vencimiento del carnet"), Licencia::getVencimientoNac));
        addItem("vencimiento del curso", new PreviewItem<>(dateField("Vencimiento del curso"), Licencia::getVencimientoCurso));
        addItem("habilitado para carga", new PreviewItem<>(new Checkbox("Habilitado para carga"), Licencia::getLicenciaCarga));
    }
}
