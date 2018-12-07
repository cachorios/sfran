package com.gmail.sanfrancisco.view.cuerocostoinsumo;

import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumo;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumoImpuesto;
import com.gmail.sanfrancisco.view.cuerocostoinsumoimpuesto.CueroCostoInsumoImpuestoForm;
import com.gmail.sanfrancisco.view.insumo.InsumoCS;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class CueroCostoInsumoInnerForm extends DefaultInnerDialog<CueroCostoInsumo> {

    private InsumoCS insumoCS;
    private TextField cantidad;
    private TextField precio;

    private Grid<CueroCostoInsumoImpuesto> impuestoGrid;
    private UnoaMuchoGrid<CueroCostoInsumo, CueroCostoInsumoImpuesto> impuestos;

    public CueroCostoInsumoInnerForm(IPresentableForm<CueroCostoInsumo> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

        setWidth("800px");

        insumoCS = new InsumoCS("Insumo", getPresentable(), true, true, true);

        cantidad = textField("Cantidad");
        precio = textField("Precio");

        form.add(
                envolver(insumoCS, "70%"),
                envolver(cantidad, "32%"),
                envolver(precio, "32%"),
                envolver(getImpuestos())
        );
    }

    private Component getImpuestos() {
        impuestos = new UnoaMuchoGrid<>("", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getImpuestos());

        impuestos.getGrid().addColumn(CueroCostoInsumoImpuesto::getImpuesto)
                .setHeader("Impuesto")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("impuesto")
                .setFooter("Total");

        impuestos.getGrid().addColumn(CueroCostoInsumoImpuesto::getSaldo)
                .setHeader("Saldo")
                .setWidth("12%")
                .setKey("saldo");

        impuestos
                .withForm(CueroCostoInsumoImpuestoForm.class)
                .withVer()
                .withNuevo(CueroCostoInsumoImpuesto.class)
                .withEditar()
                .withBorrar()
        ;
        impuestos.getGrid().setHeight("9rem");
        return impuestos.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() { return cantidad; }

    @Override
    public void bindFormFields(BeanValidationBinder<CueroCostoInsumo> binder) {

        binder.bind(insumoCS, "insumo");

        binder.forField(cantidad).withConverter(new IntegerConverter()).bind("cantidad");

        binder.forField(precio).withConverter(new DoubleConverter()).bind("precio");

        binder.bindInstanceFields(this);
    }
}