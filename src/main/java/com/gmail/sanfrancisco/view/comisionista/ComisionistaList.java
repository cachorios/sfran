package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.vaadin.flow.component.grid.Grid;

import javax.inject.Inject;
import java.util.Arrays;

public class ComisionistaList extends AbstractList<Comisionista> {
    @Inject
    public ComisionistaList(IPresenterList<Comisionista> presenter) {
        super(presenter);

    }

    @Override
    public String getTagVista(){ return "COMISIONISTA"; }

    @Override
    public Class<Comisionista> getEntityType() { return Comisionista.class; }

    @Override
    public String getTitulo() { return "Lista de Comisionistas"; }

    @Override
    protected ILayoutInnerList<Comisionista> generarLayout(AbstractList<Comisionista> padre, String titulo) {
        return new ComisionistaInnerList(padre, getTitulo());
    }

    @Override
    public void setCols(Grid<Comisionista> grilla) {
        grilla.addColumn(Comisionista::getNombre)
                .setHeader("Nombre")
                .setWidth("60%x")
                .setKey("nombre");

        grilla.addColumn(Comisionista::getCelular)
                .setHeader("Celular")
                .setWidth("20%")
                .setKey("celular");

        grilla.addColumn(Comisionista::getSaldoInicial)
                .setHeader("Inicio")
                .setWidth("20%")
                .setKey("saldoInicial");


    }


}