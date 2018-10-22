package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.customs.commons.AbstractCustomSelect;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.dataProvider.ConductorDataProvider;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.gmail.sanfrancisco.serviciosModelo.ConductorService;

import javax.enterprise.inject.spi.CDI;
import java.util.Arrays;
import java.util.List;

public class ConductorCS extends AbstractCustomSelect {
    public ConductorCS(String caption, IVisualizable padre, boolean conBuscar, boolean conVer, boolean conAdd) {
        super(caption, conBuscar, conVer, conAdd, padre);
    }

    @Override
    protected FilterablePageableDataProvider generarDataProvider() {
        return CDI.current().select(ConductorDataProvider.class).get();
    }

    @Override
    protected Conductor getElemento(String codigo) {
        return CDI.current().select(ConductorService.class).get().load(Long.valueOf(codigo));
    }

    @Override
    protected void verElemento() {
        new ConductorForm(new ConductorFormPresenter(CDI.current().select(ConductorService.class).get()), this.getPadre())
                .iniciar(EModoVista.VER, getValue());

    }

    @Override
    protected String getListTitulo() {
        return "Lista de Conductores";
    }

    @Override
    protected List<ColumnList> getListaCols() {
        return Arrays.asList(new ColumnList<>(Conductor::getId, "Código", "id", true),
                new ColumnList<>(Conductor::getNombre, "Razón Social", "nombre", true),
                new ColumnList<>(Conductor::getCuil, "CUIT", "cuil", true)
        );
    }


    @Override
    protected IPresentableForm getFormAgregar() {
        return new ConductorForm(new ConductorFormPresenter(CDI.current().select(ConductorService.class).get()), this.getPadre());
    }
}
