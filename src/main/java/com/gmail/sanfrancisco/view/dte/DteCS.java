package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.customs.commons.AbstractCustomSelect;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.sanfrancisco.dataProvider.DteDataProvider;
import com.gmail.sanfrancisco.entidad.Dte;
import com.gmail.sanfrancisco.serviciosModelo.DteService;

import javax.enterprise.inject.spi.CDI;
import java.util.Arrays;
import java.util.List;

public class DteCS extends AbstractCustomSelect {
    Dte dte;

    public DteCS(String caption, IVisualizable padre, boolean conBuscar, boolean conVer, boolean conAdd) {
        super(caption, conBuscar, conVer, conAdd, padre);
    }

    @Override
    protected FilterablePageableDataProvider generarDataProvider() {
        return CDI.current().select(DteDataProvider.class).get();
    }

    @Override
    protected Dte getElemento(String codigo) {
        return CDI.current().select(DteService.class).get().getDteByNumeroTropa(codigo);
    }

    @Override
    protected String getCodigo() {
        try {
            return dte.getNumeroTropa();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    @Override
    protected void onCambioValorManual(String valor){
        try {
            if (valor != null && valor != "") {
                dte = getElemento(valor);
                if (dte != null) {
                    setValue(dte);
                    this.setModelValue(dte,true);
                    return;
                }
            }
        } catch (Exception ex) {
            Sistema.getSistema()
                    .mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_ERR_CS_CANTSHOW_ITEM, C.MSJ_ERR_CS_NOITEM);
//            descripcion.setValue("Valor invalido...");
//            codigo.setValue(getCodigo());
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
        return Arrays.asList(new ColumnList<>(Dte::getId, "Código", "id", true),
                new ColumnList<>(Dte::getNumeroTropa, "Numero de tropa", "numetroTropa", true)
        );
    }


    @Override
    protected IPresentableForm getFormAgregar() {
        return new DteForm(new DteFormPresenter(CDI.current().select(DteService.class).get()), this.getPadre());
    }


}