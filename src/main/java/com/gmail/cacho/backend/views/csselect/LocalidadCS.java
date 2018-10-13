package com.gmail.cacho.backend.views.csselect;


import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.comunes.R;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;

public class LocalidadCS extends ParamCSComponent {
    public LocalidadCS(String caption, IVisualizable padre) {
        super(caption, padre, true, true);
    }

    @Override
    protected ETipoParametro getTipoParametro() {
        return ETipoParametro.LOCALIDAD;
    }

    @Override
    protected String getListTitulo() {
        return R.WIN_TIT_SELLOCALIDAD;
    }
}