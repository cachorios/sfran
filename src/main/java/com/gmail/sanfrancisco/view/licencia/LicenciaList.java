package com.gmail.sanfrancisco.view.licencia;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Licencia;

import javax.inject.Inject;
import java.util.Arrays;

public class LicenciaList  extends AbstractList<Licencia> {
    @Inject
    public LicenciaList(IPresenterList<Licencia> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Licencia::getTipoLicencia,"Tipo de licencia","tipo de licencia", true),
                new ColumnList<>(Licencia::getVencimiento,"Vencimiento","vencimiento", true),
                new ColumnList<>(Licencia::getLicenciaCarga,"Licencia carga","licencia carga", true)

        ));
    }

    @Override
    public String getTagVista() {
        return "LICENCIA";
    }

    @Override
    public Class<Licencia> getEntityType() {
        return Licencia.class;
    }

    @Override
    public String getTitulo() {
        return "Lista de Licencias";
    }
}
