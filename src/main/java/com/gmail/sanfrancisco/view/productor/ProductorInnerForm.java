package com.gmail.sanfrancisco.view.productor;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.dataProvider.ParametroVarioDataProvider;
import com.gmail.sanfrancisco.entidad.Productor;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.gmail.sanfrancisco.view.renspa.RenspaForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ProductorInnerForm extends DefaultInnerDialog<Productor> {

    private TextField id;
    private TextField nombre;
    private TextField cuil;
    private TextField celular;
    private TextField telefono;
    private TextField domicilio;
    private TextField email;
    private ComboBox condicion;

    private Grid<Renspa> renspaGrid;
    private UnoaMuchoGrid<Productor, Renspa> renspas;

    public ProductorInnerForm(IPresentableForm<Productor> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

//        setHeight("504px");
        setWidth("700px");

        id = textField("ID","20em");
        id.setPreventInvalidInput(true);
        nombre = textField("Rázon social");
        cuil = textField("Cuil");
        celular = textField("Celular");
        telefono = textField("Telefono");
        domicilio = textField("Domicilio");
        email = textField("Correo electronico");

        condicion = new ComboBox("Condicion frente al iva");
        condicion.setWidth("100%");
        ParametroVarioDataProvider dpCondicion = getObject(ParametroVarioDataProvider.class);
        dpCondicion.setTipo(ETipoParametro.CONDICION_IVA);
        condicion.setDataProvider(dpCondicion);


        form.add(
                envolver(id),

                envolver(nombre, "48%"),
                envolver(cuil,"48%"),

                envolver(celular,"48%"),
                envolver(telefono,"48%"),

                envolver(domicilio,"100%"),

                envolver(email, "100%"),

                envolver(condicion,"48%"),

                envolver(getRenspas())
        );

    }

    private Component getRenspas() {
        renspas = new UnoaMuchoGrid<>("Renspas", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getRenspas());

        renspas.getGrid().addColumn(Renspa::getNumeroRenspa)
                .setHeader("Numero")
                .setWidth("50%");

        renspas
                .withForm(RenspaForm.class)
                .withVer()
                .withNuevo(Renspa.class)
                .withEditar()
                .withBorrar()
        ;
        renspas.getGrid().setHeight("10rem");
        return renspas.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() { return nombre; }

    @Override
    public void bindFormFields(BeanValidationBinder<Productor> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l,"No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Productor::getId, null);

        binder.bind(condicion, "condicion");

        binder.bindInstanceFields( this);
    }
}