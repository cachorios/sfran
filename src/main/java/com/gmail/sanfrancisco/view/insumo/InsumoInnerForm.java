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

    private TextField descripcion;
    private ComboBox tipoInsumo;
    private ComboBox unidad;

    public InsumoInnerForm(IPresentableForm<Insumo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

//        setHeight("252px");
        setWidth("700px");

        descripcion = textField("Descripción");

        tipoInsumo = new ComboBox("Tipo insumo");
        tipoInsumo.setWidth("100%");
        ParametroVarioDataProvider dpTipoInsumo = getObject(ParametroVarioDataProvider.class);
        dpTipoInsumo.setTipo(ETipoParametro.TIPO_INSUMO);
        tipoInsumo.setDataProvider(dpTipoInsumo);

        unidad = new ComboBox("Unidad");
        unidad.setWidth("100%");
        ParametroVarioDataProvider dpUnidad = getObject(ParametroVarioDataProvider.class);
        dpUnidad.setTipo(ETipoParametro.UNIDAD);
        unidad.setDataProvider(dpUnidad);


        form.add(
                envolver(descripcion),

                envolver(tipoInsumo,    "48%"),
                envolver(unidad,        "48%")
        );
    }

    @Override
    public Focusable getPrimerElementoForm() { return descripcion; }

    @Override
    public void bindFormFields(BeanValidationBinder<Insumo> binder) {


        binder.bind(tipoInsumo, "tipoInsumo");

        binder.bind(unidad, "unidadMedida");

        binder.bindInstanceFields(this);
    }
}
