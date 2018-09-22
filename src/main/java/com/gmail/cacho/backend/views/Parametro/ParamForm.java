package com.gmail.cacho.backend.views.Parametro;


import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.slapi.comunes.Recursos;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class ParamForm extends AbstractForm<Parametro> {
    @Inject
    public ParamForm(IPresenterForm<Parametro> presenter) {
        super(presenter);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return ((ParamInnerForm)getViewComponent()).getPrimerElementoForm();
    }

    @Override
    public String getTagVista() {
        return Recursos.RCV_TAG_PARAM;
    }

    @Override
    public Class<Parametro> getEntityType() {
        return Parametro.class;
    }

    @Override
    public String getTitulo() {
        return Recursos.RCV_TITULO_FORM_PARAM;
    }

    @Override
    protected ILayoutInnerForm<Parametro> generarLayout(AbstractForm<Parametro> padre, String titulo) {
        return new ParamInnerForm(padre, titulo);
    }
}