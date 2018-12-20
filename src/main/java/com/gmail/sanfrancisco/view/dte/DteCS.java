package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.customs.commons.AbstractCustomSelect;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.cacho.slbase.core.StringTools;
import com.gmail.sanfrancisco.dataProvider.TropaProductorDataProvider;
import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.entidad.Productor;
import com.gmail.sanfrancisco.serviciosModelo.DteService;

import javax.enterprise.inject.spi.CDI;
import java.util.Arrays;
import java.util.List;

public class DteCS extends AbstractCustomSelect<Dte> {
    private Productor productor;
    TropaProductorDataProvider dpTropa;

    public DteCS(String caption, IVisualizable padre, boolean conBuscar, boolean conVer, boolean conAdd) {
        super(caption, conBuscar, conVer, conAdd, padre);
        dpTropa = CDI.current().select(TropaProductorDataProvider.class).get();
    }

    @Override
    protected FilterablePageableDataProvider generarDataProvider() {

        dpTropa.setProductor(productor);
        return dpTropa;
    }

    @Override
    protected Dte getElemento(String codigo) {
        codigo = StringTools.right("0000"+codigo, 4);
        return CDI.current().select(DteService.class).get().getDteByNumeroTropa(codigo, productor);
    }

    @Override
    protected String getCodigo() {
        try {
            return getValue().getNumeroTropa();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    @Override
    protected void verElemento() {
        new DteForm(new DteFormPresenter(CDI.current().select(DteService.class).get()), this.getPadre())
                .iniciar(EModoVista.VER, getValue());

    }

    @Override
    protected String getListTitulo() {
        return "Lista de Dtes";
    }

    @Override
    protected List<ColumnList> getListaCols() {
        return Arrays.asList(new ColumnList<>(Dte::getNumeroTropa, "Numero de tropa", "numetroTropa", true),
                new ColumnList<>(Dte::getComisionista, "Comisionista", "comisionista", true),
                new ColumnList<>(Dte::getLocalidadOrigen, "Localidad origen", "localidadOrigen", true),
                new ColumnList<>(Dte::getLocalidadDestino, "Localidad destino", "localidadDestino", true)
        );
    }

    public void setProductor(Productor p) {
        productor = p;
        dpTropa.setProductor(productor);
    }


    /*@Override
    protected IPresentableForm getFormAgregar() {
        return new DteForm(new DteFormPresenter(CDI.current().select(DteService.class).get()), this.getPadre());
    }*/


}