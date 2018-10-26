package com.gmail.sanfrancisco.view.consignatario;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.customs.commons.AbstractCustomSelect;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.dataProvider.ConsignatarioDataProvider;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.gmail.sanfrancisco.serviciosModelo.ConsignatarioService;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.TextField;

import javax.enterprise.inject.spi.CDI;
import java.util.Arrays;
import java.util.List;

public class ConsignatarioCS extends AbstractCustomSelect {

    public ConsignatarioCS(String caption, IVisualizable padre, boolean conBuscar, boolean conVer, boolean conAdd) {
        super(caption, conBuscar, conVer, conAdd, padre);
    }

    @Override
    protected FilterablePageableDataProvider generarDataProvider() {
        return CDI.current().select(ConsignatarioDataProvider.class).get();
    }

    @Override
    protected Consignatario getElemento(String codigo) {
        return CDI.current().select(ConsignatarioService.class).get().load(Long.valueOf(codigo));
    }

    @Override
    protected void verElemento() {
        new ConsignatarioForm(new ConsignatarioFormPresenter(CDI.current().select(ConsignatarioService.class).get()), this.getPadre())
                .iniciar(EModoVista.VER, getValue());

    }

    @Override
    protected String getListTitulo() {
        return "Lista de Consignatarios";
    }

    @Override
    protected List<ColumnList> getListaCols() {
        return Arrays.asList(new ColumnList<>(Consignatario::getId, "Código", "id", true),
                new ColumnList<>(Consignatario::getNombre, "Razón Social", "nombre", true),
                new ColumnList<>(Consignatario::getCuil, "CUIT", "cuil", true)
        );
    }


    @Override
    protected IPresentableForm getFormAgregar() {
        return new ConsignatarioForm(new ConsignatarioFormPresenter(CDI.current().select(ConsignatarioService.class).get()), this.getPadre());
    }
}