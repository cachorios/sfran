package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.dataProvider.DteDataProvider;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.gmail.sanfrancisco.entidad.Faena;
import com.gmail.sanfrancisco.view.dte.DteCS;
import com.gmail.sanfrancisco.view.productor.ProductorCS;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.function.ValueProvider;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FaenaInnerForm extends DefaultInnerDialog<Faena> {
    private DatePicker fecha;
    private TextField numero;

    private ProductorCS productorCS;
    private DteCS dteCS;

    private VerticalLayout cabezeraLayout;
    private VerticalLayout detalleLayout;

    public FaenaInnerForm(IPresentableForm<Faena> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        numero = textField("Numero");
        fecha = dateField("Fecha");

        productorCS = new ProductorCS("Productor", getPresentable(), true, true, true);
        productorCS.addValueChangeListener(e-> {this.cabezeraChanged(e, productorCS, dteCS);});
        dteCS = new DteCS("Dte", getPresentable(), true, true, true);
        dteCS.addValueChangeListener(e-> {this.cabezeraChanged(e, productorCS, dteCS);});

        form.add(
                envolver(fecha, "48%"),
                envolver(numero, "50%"),

                envolver(productorCS, "48%"),
                envolver(dteCS, "50%"),
                envolver(cabezeraLayout),
                envolver(detalleLayout)
        );
    }

    @Override
    public Focusable getPrimerElementoForm() { return numero; }

    private void cabezeraChanged(HasValue.ValueChangeEvent<?> e, ProductorCS productorCS, DteCS dteCS) {
        cabezeraLayout.removeAll();
        if(e.getValue() != null){

        }
        /*ValueProvider<DteDetalleCategoria, String> categorias;
        categorias = (dteDetalleCategoria) -> {

        };*/
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
