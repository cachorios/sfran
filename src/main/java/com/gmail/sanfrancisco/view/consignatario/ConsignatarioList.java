package com.gmail.sanfrancisco.view.consignatario;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.vaadin.flow.data.renderer.NumberRenderer;

import javax.inject.Inject;
import java.util.Arrays;

public class ConsignatarioList extends AbstractList<Consignatario> {
    @Inject
    public ConsignatarioList(IPresenterList<Consignatario> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Consignatario::getNombre, "Nombre", "nombre", true),
                new ColumnList<>(Consignatario::getCelular, "Celular", "celular", true),
                new ColumnList<>(Consignatario::getTelefono, "Telefono", "telefono", true)
        ));
    }

    @Override
    public String getTagVista() { return "CONSIGNATARIO"; }

    @Override
    public Class<Consignatario> getEntityType(){ return Consignatario.class; }

    @Override
    public String getTitulo() { return "Lista de Consignatarios"; }

    @Override
    protected ILayoutInnerList<Consignatario> generarLayout(AbstractList<Consignatario> padre, String titulo) {
        return new ConsignatarioInnerList(padre, getTitulo());
    }
}
