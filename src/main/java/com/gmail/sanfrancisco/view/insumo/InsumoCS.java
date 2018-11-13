package com.gmail.sanfrancisco.view.insumo;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.customs.commons.AbstractCustomSelect;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.dataProvider.InsumoDataProvider;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.gmail.sanfrancisco.serviciosModelo.InsumoService;

import javax.enterprise.inject.spi.CDI;
import java.util.Arrays;
import java.util.List;

public class InsumoCS extends AbstractCustomSelect {
    public InsumoCS(String caption, IVisualizable padre, boolean conBuscar, boolean conVer, boolean conAdd) {
        super(caption, conBuscar, conVer, conAdd, padre);
    }

    @Override
    protected FilterablePageableDataProvider generarDataProvider() {
        return CDI.current().select(InsumoDataProvider.class).get();
    }

    @Override
    protected Insumo getElemento(String codigo) {
        return CDI.current().select(InsumoService.class).get().load(Long.valueOf(codigo));
    }

    @Override
    protected void verElemento() {
        new InsumoForm(new InsumoFormPresenter(CDI.current().select(InsumoService.class).get()), this.getPadre())
                .iniciar(EModoVista.VER, getValue());

    }

    @Override
    protected String getListTitulo() {
        return "Lista de Insumos";
    }

    @Override
    protected List<ColumnList> getListaCols() {
        return Arrays.asList(new ColumnList<>(Insumo::getId, "Código", "id", true),
                new ColumnList<>(Insumo::getDescripcion, "Descripción", "descripcion", true)
        );
    }


    @Override
    protected IPresentableForm getFormAgregar() {
        return new InsumoForm(new InsumoFormPresenter(CDI.current().select(InsumoService.class).get()), this.getPadre());
    }
}
