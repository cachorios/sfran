package com.gmail.sanfrancisco.view.vehiculocostoinsumo;

import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumoImpuesto;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumo;
import com.gmail.sanfrancisco.view.vehiculocostoinsumoimpuesto.VehiculoCostoInsumoImpuestoForm;
import com.gmail.sanfrancisco.view.insumo.InsumoCS;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class VehiculoCostoInsumoInnerForm extends DefaultInnerDialog<VehiculoCostoInsumo> {

    private InsumoCS insumoCS;
    private TextField cantidad;
    private TextField precio;

    private Grid<VehiculoCostoInsumoImpuesto> impuestoGrid;
    private UnoaMuchoGrid<VehiculoCostoInsumo, VehiculoCostoInsumoImpuesto> impuestos;

    public VehiculoCostoInsumoInnerForm(IPresentableForm<VehiculoCostoInsumo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setHeight("310px");
        setWidth("700px");

        insumoCS = new InsumoCS("Insumo", getPresentable(), true, true, true);

        cantidad = textField("Cantidad");
        precio = textField("Precio");

        form.add(
                envolver(insumoCS, "70%"),

                envolver(cantidad,"32%"),
                envolver(precio,"32%"),
                envolver(getImpuestos())
        );

    }

    private Component getImpuestos() {
        impuestos = new UnoaMuchoGrid<>("", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getImpuestos());

        impuestos.getGrid().addColumn(VehiculoCostoInsumoImpuesto::getImpuesto)
                .setHeader("Impuesto")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("impuesto")
                .setFooter("Total");

        impuestos.getGrid().addColumn(VehiculoCostoInsumoImpuesto::getSaldo)
                .setHeader("Saldo")
                .setWidth("12%")
                .setKey("saldo");

        impuestos
                .withForm(VehiculoCostoInsumoImpuestoForm.class)
                .withVer()
                .withNuevo(VehiculoCostoInsumoImpuesto.class)
                .withEditar()
                .withBorrar()
        ;
        impuestos.getGrid().setHeight("9rem");
        return impuestos.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() { return precio; }

    @Override
    public void bindFormFields(BeanValidationBinder<VehiculoCostoInsumo> binder) {

        binder.bind(insumoCS, "insumo");

        binder.forField(cantidad).withConverter(new IntegerConverter()).bind("cantidad");

        binder.forField(precio).withConverter(new DoubleConverter()).bind("precio");


        binder.bindInstanceFields( this);
    }
}