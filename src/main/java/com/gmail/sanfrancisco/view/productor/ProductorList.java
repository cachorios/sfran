package com.gmail.sanfrancisco.view.productor;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Productor;

import javax.inject.Inject;
import java.util.Arrays;

public class ProductorList extends AbstractList<Productor> {
    @Inject
    public ProductorList(IPresenterList<Productor> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Productor::getNombre,"Nombre","nombre", true),
                new ColumnList<>(Productor::getCelular,"Celular","celular", true),
                new ColumnList<>(Productor::getCondicion,"Condicion frente al iva","condicion", true)
        ));
    }

    @Override
    public String getTagVista(){ return "PRODUCTOR"; }

    @Override
    public Class<Productor> getEntityType() { return Productor.class; }

    @Override
    public String getTitulo() { return "Lista de Productores"; }

    @Override
    protected ILayoutInnerList<Productor> generarLayout(AbstractList<Productor> padre, String titulo) {
        return new ProductorInnerList(padre, getTitulo());
    }
}
