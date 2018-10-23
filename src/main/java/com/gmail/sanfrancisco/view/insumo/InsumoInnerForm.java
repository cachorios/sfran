package com.gmail.sanfrancisco.view.insumo;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.dataProvider.ParametroVarioDataProvider;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class InsumoInnerForm extends DefaultInnerDialog<Insumo> {

    private TextField id;
    private TextField descripcion;
    private ComboBox tipoInsumo;
    private TextField unidad;

    public InsumoInnerForm(IPresentableForm<Insumo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

//        setHeight("252px");
        setWidth("700px");

        id = textField("ID","20em");
        id.setPreventInvalidInput(true);
        descripcion = textField("Descripción");

        tipoInsumo = new ComboBox("Tipo insumo");
        tipoInsumo.setWidth("100%");
        ParametroVarioDataProvider dpTipoInsumo = getObject(ParametroVarioDataProvider.class);
        dpTipoInsumo.setTipo(ETipoParametro.TIPO_INSUMO);
        tipoInsumo.setDataProvider(dpTipoInsumo);

        unidad = textField("Unidad");


        form.add(
                envolver(id),

                envolver(descripcion),

                envolver(tipoInsumo,    "48%"),
                envolver(unidad,        "48%")
        );
    }

    @Override
    public Focusable getPrimerElementoForm() { return descripcion; }

    @Override
    public void bindFormFields(BeanValidationBinder<Insumo> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Insumo::getId, null);

        binder.bind(tipoInsumo, Insumo::getTipoInsumo, Insumo::setTipoInsumo);

        binder.forField(unidad)
                .withConverter(new StringToLongConverter("No es un nro válido."))
                .bind(Insumo::getUnidad, Insumo::setUnidad);

        binder.bindInstanceFields(this);
    }
}
