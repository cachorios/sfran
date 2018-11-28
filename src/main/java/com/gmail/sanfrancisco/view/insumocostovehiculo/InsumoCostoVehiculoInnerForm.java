package com.gmail.sanfrancisco.view.insumocostovehiculo;

import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.entidad.ImpuestoCostoVehiculo;
import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;
import com.gmail.sanfrancisco.view.impuestocostovehiculo.ImpuestoCostoVehiculoForm;
import com.gmail.sanfrancisco.view.insumo.InsumoCS;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class InsumoCostoVehiculoInnerForm extends DefaultInnerDialog<InsumoCostoVehiculo> {

    private InsumoCS insumoCS;
    private TextField cantidad;
    private TextField precio;

    private Grid<ImpuestoCostoVehiculo> impuestoGrid;
    private UnoaMuchoGrid<InsumoCostoVehiculo, ImpuestoCostoVehiculo> impuestos;

    public InsumoCostoVehiculoInnerForm(IPresentableForm<InsumoCostoVehiculo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("588px");
        setWidth("700px");

        insumoCS = new InsumoCS("Insumo", getPresentable(), true, true, true);

        cantidad = textField("Cantidad");
        precio = textField("Precio");

        form.add(
                envolver(insumoCS),

                envolver(cantidad,"48%"),
                envolver(precio,"48%"),
                envolver(getImpuestos())
        );

    }

    private Component getImpuestos() {
        impuestos = new UnoaMuchoGrid<>("", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getImpuestos());

        impuestos.getGrid().addColumn(ImpuestoCostoVehiculo::getImpuesto)
                .setHeader("Impuesto")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("impuesto")
                .setFooter("Total");

        impuestos.getGrid().addColumn(ImpuestoCostoVehiculo::getSaldo)
                .setHeader("Saldo")
                .setWidth("12%")
                .setKey("saldo");

        impuestos
                .withForm(ImpuestoCostoVehiculoForm.class)
                .withVer()
                .withNuevo(ImpuestoCostoVehiculo.class)
                .withEditar()
                .withBorrar()
        ;
        impuestos.getGrid().setHeight("9rem");
        return impuestos.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() { return precio; }

    @Override
    public void bindFormFields(BeanValidationBinder<InsumoCostoVehiculo> binder) {

        binder.bind(insumoCS, "insumo");

        binder.forField(cantidad).withConverter(new IntegerConverter()).bind("cantidad");

        binder.forField(precio).withConverter(new DoubleConverter()).bind("precio");


        binder.bindInstanceFields( this);
    }
}