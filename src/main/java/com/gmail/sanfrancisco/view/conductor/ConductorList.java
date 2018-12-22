package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.renders.DateRenderer;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.component.grid.Grid;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ConductorList extends AbstractList<Conductor> {
    @Inject
    public ConductorList(IPresenterList<Conductor> presenter) {
        super(presenter);
//        setListaCols(Arrays.asList(
//                new ColumnList<>(Conductor::getNombre, "Nombre", "nombre", true),
//                new ColumnList<>(Conductor::getDni, "D.N.I.", "dni", true),
//                new ColumnList<>(new DateRenderer<>(Conductor::getFechaNacimiento, "dd/MM/yyyy"), "Nacimiento", "fechaNacimiento", true),
//                new ColumnList<>(new DateRenderer<>(Conductor::getFechaIngreso, "dd/MM/yyyy"), "Ingreso", "fechaIngreso", true)
//        ));
    }

    @Override
    public void setCols(Grid<Conductor> grilla) {
        grilla.addColumn(Conductor::getNombre)
                .setHeader("Nombre")
                .setWidth("43%")
                .setKey("nombre")
                .setSortable(true);
        grilla.addColumn(Conductor::getDni)
                .setHeader("Nro.DNI")
                .setWidth("15%")
                .setKey("dni")
                .setSortable(true);
        grilla.addColumn(new DateRenderer<>(Conductor::getFechaNacimiento, "dd/MM/yyyy"))
                .setHeader("Nacimiento")
                .setWidth("20%")
                .setKey("fechaNacimiento")
                .setSortable(true);
        grilla.addColumn(new DateRenderer<>(Conductor::getFechaIngreso, "dd/MM/yyyy"))
                .setHeader("Ingreso")
                .setWidth("20%")
                .setKey("fechaIngreso")
                .setSortable(true);

    }

    @Override
    public String getTagVista() {
        return "CONDUCTOR";
    }

    @Override
    public Class<Conductor> getEntityType() {
        return Conductor.class;
    }

    @Override
    public String getTitulo() {
        return "Lista de Conductores";
    }

    @Override
    protected ILayoutInnerList<Conductor> generarLayout(AbstractList<Conductor> padre, String titulo) {
        return new ConductorInnerList(padre, getTitulo());
    }

}

