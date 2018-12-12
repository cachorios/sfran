package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.dataProvider.DteDataProvider;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.gmail.sanfrancisco.entidad.Faena;
import com.gmail.sanfrancisco.entidad.Productor;
import com.gmail.sanfrancisco.view.dte.DteCS;
import com.gmail.sanfrancisco.view.productor.ProductorCS;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.function.ValueProvider;

import java.util.List;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FaenaInnerForm extends DefaultInnerDialog<Faena> {
    private DatePicker fecha;
    private TextField numero;

    private ProductorCS productorCS;
    private DteCS dteCS;

    private VerticalLayout vlDetalleSuperior;
    private VerticalLayout vlDetalleInferior;

    public FaenaInnerForm(IPresentableForm<Faena> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {
        setWidth("1100px");

        numero = textField("Numero");
        fecha = dateField("Fecha");

        productorCS = new ProductorCS("Productor", getPresentable(), true, true, true);
        productorCS.addValueChangeListener(e-> {this.productorChanged(e, dteCS);});
        dteCS = new DteCS("Tropa", getPresentable(), true, true, false);
        dteCS.setEnabled(false);
        dteCS.addValueChangeListener(e-> {this.dteChanged(e);});

        vlDetalleSuperior = new VerticalLayout();
        vlDetalleInferior = new VerticalLayout();

        form.add(
                envolver(fecha, "48%"),
                envolver(numero, "50%"),

                envolver(productorCS, "48%"),
                envolver(dteCS, "50%"),

                envolver(vlDetalleSuperior),
                envolver(vlDetalleInferior)
        );
    }

    @Override
    public Focusable getPrimerElementoForm() { return numero; }

    private void productorChanged(HasValue.ValueChangeEvent<?> e, DteCS dteCS) {
        if(productorCS.getValue() != null){
            dteCS.setEnabled(true);
            dteCS.setProductor((Productor)productorCS.getValue());
            dteCS.setValue(null);
        }
    }

    private void dteChanged(HasValue.ValueChangeEvent<?> e) {
        if(dteCS.getValue() != null){
            vlDetalleSuperior.removeAll();
            for (DteDetalleCategoria i : dteCS.getValue().getCategorias()) {
                vlDetalleSuperior.add(new FaenaDetalleSuperior());
            }
        } else {
            vlDetalleSuperior.removeAll();
        }
    }

    @Override
    public void bindFormFields(BeanValidationBinder<Faena> binder) {
        binder.forField(fecha)
                .withConverter(new LocalDateADateConverter())
                .bind(Faena::getFecha, Faena::setFecha);

        binder.forField(numero).withConverter(new IntegerConverter()).bind("numero");

        binder.bindInstanceFields(this);
    }
}
