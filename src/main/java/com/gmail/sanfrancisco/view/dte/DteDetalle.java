package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.sanfrancisco.view.productor.ProductorCS;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;


public class DteDetalle extends HorizontalLayout implements IVisualizable {
    private Button btnRemove;

    private ProductorCS productorCS;
    private ComboBox renspa;

    private ComboBox categoria;
    private TextField cantidad;
    private TextField kgVivo;
    private TextField precioKgVivo;
    private TextField kgCarne;
    private TextField porcentajeComision;

    public DteDetalle() {

        btnRemove = new Button(VaadinIcon.TRASH.create());
        VerticalLayout linea = new VerticalLayout();
        add(linea, btnRemove);

        HorizontalLayout linea1 = new HorizontalLayout();
        HorizontalLayout linea2 = new HorizontalLayout();
        linea.add(linea1, linea2);

        productorCS = new ProductorCS("Productor", this,true,true, true);
        renspa = new ComboBox("Renspa");
        categoria = new ComboBox("Categoria");

        linea1.add(productorCS, renspa, categoria);

        cantidad = new TextField("Cantidad");
        kgVivo = new TextField("Kg vivos");
        precioKgVivo = new TextField("Precio por kg vivo");
        kgCarne = new TextField("Kg carne");
        porcentajeComision = new TextField("Porcentaje de comision");

        linea2.add(cantidad, kgVivo, precioKgVivo, kgCarne, porcentajeComision);
    }

    @Override
    public void iniciar(EModoVista modo, AbstractEntidad item) {

    }

    @Override
    public EModoVista getModoVista() {
        return null;
    }

    @Override
    public Component getViewComponent() {
        return this;
    }

    @Override
    public void cerrar() {

    }

    @Override
    public IVisualizable getPadre() {
        return null;
    }

    @Override
    public void setPadre(IVisualizable padre) {

    }
}
