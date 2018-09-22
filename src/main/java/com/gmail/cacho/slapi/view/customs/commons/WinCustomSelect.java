package com.gmail.cacho.slapi.view.customs.commons;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSingleSelectionModel;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

import java.util.List;

public class WinCustomSelect<T extends AbstractEntidad> extends Dialog {
    private AbstractCustomSelect<T> padre;
    protected FilterablePageableDataProvider<T, Long, String> dataProvider;
    private List<ColumnList> listaCols;
    private T registroSeleccionado;
    private Grid<T> grilla;
    private TextField filtro = new TextField();
    private Button cancelar, seleccionar, agregar;
    IPresentableForm<T> form;

    public WinCustomSelect(String caption, FilterablePageableDataProvider<T, Long, String> dataProvider, List<ColumnList> listaCols, AbstractCustomSelect<T> padre) {
        ////super(caption);
        this.padre = padre;
        this.dataProvider = dataProvider;
        this.listaCols = listaCols;


        armarVentana();
        setShortcuts();
    }

    private void armarVentana() {
        //setStyleName("sciolar-window");
        setCloseOnEsc(false);
        setCloseOnOutsideClick(false);

        setWidth("650px");
        setHeight("450px");


        HorizontalLayout filtroLayout = new HorizontalLayout();
        filtroLayout.setWidth("100%");
        filtroLayout.setHeight("60px");
        filtroLayout.add(filtro);

        seleccionar = new Button(C.CRUD_FORM_BTN_ELEGIR, e -> { padre.setValue(registroSeleccionado); close(); });
        seleccionar.setWidth("120px");
        seleccionar.setEnabled(false);

        cancelar = new Button(C.CRUD_FORM_BTN_CANCELAR,clickEvent -> close());
        cancelar.setWidth("12px%");

        HorizontalLayout botonera = new HorizontalLayout();
        botonera.setWidth("100%");
        botonera.setHeight("60px");

        if (padre.conAdd()) {
            agregar = new Button(C.CRUD_MSG_AGREGAR, e -> agregarElemento());
            agregar.setWidth("120px");
            agregar.setEnabled(true);

            botonera.add(agregar, seleccionar, cancelar);
            botonera.setAlignSelf(FlexComponent.Alignment.END,agregar);
        } else {
            botonera.add(seleccionar, cancelar);
        }
        botonera.setAlignItems(FlexComponent.Alignment.END);

        grilla = new Grid<>();
        grilla.setSelectionMode(Grid.SelectionMode.SINGLE);
        ((GridSingleSelectionModel<T>) grilla.getSelectionModel()).setDeselectAllowed(false);
        grilla.setDataProvider(dataProvider);
        if (listaCols != null) {
            listaCols.forEach(col -> {
                if (col.tieneFormato()) {
                    grilla.addColumn(col.getProveedor())
                            .setHeader(col.getTitulo())
                            .setSortable(col.isOrdenable())
                            .setId(col.getPropiedad());
                            ////.setHidable(true)
                            ////.setRenderer(col.getRenderer());

                } else {
                    grilla.addColumn(col.getProveedor())
                            .setHeader(col.getTitulo())
                            .setSortable(col.isOrdenable())
                            .setId(col.getPropiedad());
                            ////.setHidable(true);

                }
            });
        }
        grilla.deselectAll();
        grilla.setSizeFull();
        grilla.getDataProvider().refreshAll();
        grilla.addSelectionListener(e -> {
            if (e.isFromClient() && e.getFirstSelectedItem().isPresent()) {
                seleccionar.setEnabled(true);
                registroSeleccionado = e.getFirstSelectedItem().get();
            } else {
                seleccionar.setEnabled(false);
                registroSeleccionado = null;
            }
        });

        filtro.clear();
        filtro.setPlaceholder("Filtrar...");
        filtro.setWidth("100%");

        filtro.setValueChangeMode(ValueChangeMode.EAGER);
        filtro.addValueChangeListener(e -> {
            ((FilterablePageableDataProvider<T, Long, String>) grilla.getDataProvider()).setFiltro(e.getValue());
            seleccionar.setEnabled(false);
        });

        VerticalLayout layout  = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.add(filtroLayout, grilla, botonera);
        layout.setFlexGrow(0,filtroLayout);
        layout.setFlexGrow(0,botonera);
        layout.setFlexGrow(1,grilla);
        layout.expand(grilla);

        add(layout);
    }

    private void agregarElemento() {
        form = padre.getFormAgregar();
        form.setExecutableOnSaveOK(() -> { padre.setValue(form.getObjetoActivo()); close(); });
        form.iniciar(EModoVista.NUEVO, padre.getItemAdd());
    }

    private void setShortcuts() {
        ////filtro.addShortcutListener(new FocusShortcut(filtro, ShortcutAction.KeyCode.F2));
        ////seleccionar.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        ////cancelar.setClickShortcut(ShortcutAction.KeyCode.F12);
    }
}
