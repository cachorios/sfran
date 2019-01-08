package com.gmail.sanfrancisco.view.cuerocosto;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.CueroCosto;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumo;
import com.gmail.sanfrancisco.view.cuerocostoinsumo.CueroCostoInsumoForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;

public class CueroCostoInnerForm extends DefaultInnerDialog<CueroCosto> {

    private DatePicker fecha;

    private Grid<CueroCostoInsumo> insumoGrid;
    private UnoaMuchoGrid<CueroCosto, CueroCostoInsumo> insumos;

    public CueroCostoInnerForm(IPresentableForm<CueroCosto> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {
        setWidth("680px");

        fecha = dateField("Fecha");
        fecha.setWidth("32%");
        fecha.setRequired(true);

        form.add(
                envolver(fecha),
                envolver(getInsumos())
        );
    }

    private Component getInsumos() {
        insumos = new UnoaMuchoGrid<>("", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getInsumos(), this.getPresentable());

        insumos.getGrid().addColumn(CueroCostoInsumo::getInsumo)
                .setHeader("Insumo")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("insumo")
                .setFooter("Total");

        insumos.getGrid().addColumn(CueroCostoInsumo::getPrecio)
                .setHeader("Precio")
                .setWidth("12%")
                .setKey("precio");
        insumos.getGrid().addColumn(CueroCostoInsumo::getCantidad)
                .setHeader("Cantidad")
                .setWidth("10%");

        insumos
                .withForm(CueroCostoInsumoForm.class)
                .withVer()
                .withNuevo(CueroCostoInsumo.class)
                .withEditar()
                .withBorrar()
        ;
        insumos.getGrid().setHeight("9rem");
        return insumos.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() { return fecha; }

    @Override
    public void bindFormFields(BeanValidationBinder<CueroCosto> binder) {

        binder.forField(fecha)
                .withConverter(new LocalDateADateConverter())
                .bind(CueroCosto::getFecha, CueroCosto::setFecha);

        binder.bindInstanceFields( this);
    }
}