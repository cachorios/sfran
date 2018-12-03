package com.gmail.sanfrancisco.view.graseriacostoinsumo;

import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.DoubleConverter;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumo;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumoImpuesto;
import com.gmail.sanfrancisco.view.graseriacostoinsumoimpuesto.GraseriaCostoInsumoImpuestoForm;
import com.gmail.sanfrancisco.view.insumo.InsumoCS;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class GraseriaCostoInsumoInnerForm extends DefaultInnerDialog<GraseriaCostoInsumo> {

    private InsumoCS insumoCS;
    private TextField cantidad;
    private TextField precio;

    private Grid<GraseriaCostoInsumoImpuesto> impuestoGrid;
    private UnoaMuchoGrid<GraseriaCostoInsumo, GraseriaCostoInsumoImpuesto> impuestos;

    public GraseriaCostoInsumoInnerForm(IPresentableForm<GraseriaCostoInsumo> presentable, String elTitulo) {
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

        impuestos.getGrid().addColumn(GraseriaCostoInsumoImpuesto::getImpuesto)
                .setHeader("Impuesto")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("impuesto")
                .setFooter("Total");

        impuestos.getGrid().addColumn(GraseriaCostoInsumoImpuesto::getSaldo)
                .setHeader("Saldo")
                .setWidth("12%")
                .setKey("saldo");

        impuestos
                .withForm(GraseriaCostoInsumoImpuestoForm.class)
                .withVer()
                .withNuevo(GraseriaCostoInsumoImpuesto.class)
                .withEditar()
                .withBorrar()
        ;
        impuestos.getGrid().setHeight("9rem");
        return impuestos.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() { return cantidad; }

    @Override
    public void bindFormFields(BeanValidationBinder<GraseriaCostoInsumo> binder) {

        binder.bind(insumoCS, "insumo");

        binder.forField(cantidad).withConverter(new IntegerConverter()).bind("cantidad");

        binder.forField(precio).withConverter(new DoubleConverter()).bind("precio");

        binder.bindInstanceFields(this);
    }
}
