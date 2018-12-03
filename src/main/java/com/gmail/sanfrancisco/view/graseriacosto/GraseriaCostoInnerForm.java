package com.gmail.sanfrancisco.view.graseriacosto;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.entidad.GraseriaCosto;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumo;
import com.gmail.sanfrancisco.view.graseriacostoinsumo.GraseriaCostoInsumoForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;

public class GraseriaCostoInnerForm extends DefaultInnerDialog<GraseriaCosto> {

    private DatePicker fecha;

    private Grid<GraseriaCostoInsumo> insumoGrid;
    private UnoaMuchoGrid<GraseriaCosto, GraseriaCostoInsumo> insumos;

    public GraseriaCostoInnerForm(IPresentableForm<GraseriaCosto> presentable, String elTitulo) {
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
        insumos = new UnoaMuchoGrid<>("", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getInsumos());

        insumos.getGrid().addColumn(GraseriaCostoInsumo::getInsumo)
                .setHeader("Insumo")
                .setWidth("20%")
                .setFlexGrow(1)
                .setKey("insumo")
                .setFooter("Total");

        insumos.getGrid().addColumn(GraseriaCostoInsumo::getPrecio)
                .setHeader("Precio")
                .setWidth("12%")
                .setKey("precio");
        insumos.getGrid().addColumn(GraseriaCostoInsumo::getCantidad)
                .setHeader("Cantidad")
                .setWidth("10%");

        insumos
                .withForm(GraseriaCostoInsumoForm.class)
                .withVer()
                .withNuevo(GraseriaCostoInsumo.class)
                .withEditar()
                .withBorrar()
        ;
        insumos.getGrid().setHeight("9rem");
        return insumos.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() { return fecha; }

    @Override
    public void bindFormFields(BeanValidationBinder<GraseriaCosto> binder) {

        binder.forField(fecha)
        .withConverter(new LocalDateADateConverter())
        .bind(GraseriaCosto::getFecha, GraseriaCosto::setFecha);

        binder.bindInstanceFields( this);
    }
}
