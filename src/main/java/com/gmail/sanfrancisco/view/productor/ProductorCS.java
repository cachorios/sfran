package com.gmail.sanfrancisco.view.productor;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.customs.commons.AbstractCustomSelect;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.dataProvider.ProductorDataProvider;
import com.gmail.sanfrancisco.entidad.Productor;
import com.gmail.sanfrancisco.serviciosModelo.ProductorService;

import javax.enterprise.inject.spi.CDI;
import java.util.Arrays;
import java.util.List;

public class ProductorCS extends AbstractCustomSelect {
    public ProductorCS(String caption, IVisualizable padre, boolean conBuscar, boolean conVer, boolean conAdd) {
        super(caption, conBuscar, conVer, conAdd, padre);
    }

    @Override
    protected FilterablePageableDataProvider generarDataProvider() {
        return CDI.current().select(ProductorDataProvider.class).get();
    }

    @Override
    protected Productor getElemento(String codigo) {
        return CDI.current().select(ProductorService.class).get().load(Long.valueOf(codigo));
    }

    @Override
    protected void verElemento() {
        new ProductorForm(new ProductorFormPresenter(CDI.current().select(ProductorService.class).get()), this.getPadre())
                .iniciar(EModoVista.VER, getValue());

    }

    @Override
    protected String getListTitulo() {
        return "Lista de Productores";
    }

    @Override
    protected List<ColumnList> getListaCols() {
        return Arrays.asList(new ColumnList<>(Productor::getId, "Código", "id", true),
                new ColumnList<>(Productor::getNombre, "Razón Social", "nombre", true),
                new ColumnList<>(Productor::getCuil, "CUIT", "cuil", true)
        );
    }


    @Override
    protected IPresentableForm getFormAgregar() {
        return new ProductorForm(new ProductorFormPresenter(CDI.current().select(ProductorService.class).get()), this.getPadre());
    }
}