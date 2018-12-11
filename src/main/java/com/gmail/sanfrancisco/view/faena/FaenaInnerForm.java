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

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FaenaInnerForm extends DefaultInnerDialog<Faena> {
    private DatePicker fecha;
    private TextField numero;

    private ProductorCS productorCS;
    private DteCS dteCS;

    private ParamCSComponent categoria;
    private TextField cantidad;
    private TextField faenado;
    private TextField diferencia;
    private TextField kgVivo;
    private TextField aFaenar;

    private DteCS dteCSDetalle;
    private TextField orden;
    private ParamCSComponent categoriaDetalle;
    private TextField kgIzquierdo;
    private TextField kgDerecho;

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

        categoria = new ParamCSComponent("Categoria", getPresentable(), true, true, "Categorias", ETipoParametro.CATEGORIA_ANIMAL);
        cantidad = textField("Cantidad");
        faenado = textField("Faenado");
        diferencia = textField("Diferencia");
        kgVivo = textField("Kilogramos vivos");
        aFaenar = textField("A faenar");

        orden = textField("Orden");
        categoriaDetalle = new ParamCSComponent("Categoria", getPresentable(), true, true, "Categorias", ETipoParametro.CATEGORIA_ANIMAL);
        kgIzquierdo = textField("Kilogramos izquierdo");
        kgDerecho = textField("Kilogramos derecho");


        form.add(
                envolver(fecha, "48%"),
                envolver(numero, "50%"),

                envolver(productorCS, "48%"),
                envolver(dteCS, "50%"),

                envolver(categoria,"28%"),
                envolver(cantidad,"13%"),
                envolver(faenado, "13%"),
                envolver(diferencia, "13%"),
                envolver(kgVivo,"13%"),
                envolver(aFaenar,"13%"),

                envolver(orden,"20%"),
                envolver(categoriaDetalle,"38%"),
                envolver(kgIzquierdo,"20%"),
                envolver(kgDerecho,"20%")
        );
    }

    @Override
    public Focusable getPrimerElementoForm() { return numero; }

    private void productorChanged(HasValue.ValueChangeEvent<?> e, DteCS dteCS) {

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
