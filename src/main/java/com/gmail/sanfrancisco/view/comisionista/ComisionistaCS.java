package com.gmail.sanfrancisco.view.comisionista;


import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.customs.commons.AbstractCustomSelect;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.dataProvider.ComisionistaDataProvider;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.gmail.sanfrancisco.serviciosModelo.ComisionistaService;

import javax.enterprise.inject.spi.CDI;
import java.util.Arrays;
import java.util.List;

public class ComisionistaCS extends AbstractCustomSelect {
    public ComisionistaCS(String caption, IVisualizable padre, boolean conBuscar, boolean conVer, boolean conAdd) {
        super(caption, conBuscar, conVer, conAdd, padre);
    }

    @Override
    protected FilterablePageableDataProvider generarDataProvider() {
        return CDI.current().select(ComisionistaDataProvider.class).get();
    }

    @Override
    protected Comisionista getElemento(String codigo) {
        return CDI.current().select(ComisionistaService.class).get().load(Long.valueOf(codigo));
    }

    @Override
    protected void verElemento() {
        new ComisionistaForm(new ComisionistaFormPresenter(CDI.current().select(ComisionistaService.class).get()), this.getPadre())
                .iniciar(EModoVista.VER, getValue());

    }

    @Override
    protected String getListTitulo() {
        return "Lista de Comisionistas";
    }

    @Override
    protected List<ColumnList> getListaCols() {
        return Arrays.asList(new ColumnList<>(Comisionista::getId, "Código", "id", true),
                new ColumnList<>(Comisionista::getNombre, "Razón Social", "nombre", true),
                new ColumnList<>(Comisionista::getCuil, "CUIT", "cuil", true)
        );
    }


    @Override
    protected IPresentableForm getFormAgregar() {
        return new ComisionistaForm(new ComisionistaFormPresenter(CDI.current().select(ComisionistaService.class).get()), this.getPadre());
    }
}
