package com.gmail.sanfrancisco.view.consignatario;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class ConsignatarioForm extends AbstractForm<Consignatario> {

    @Inject
    public ConsignatarioForm(IPresenterForm<Consignatario> presenter) { super(presenter); }

    public ConsignatarioForm(IPresenterForm<Consignatario> presenter, IVisualizable padre) {
        super(presenter);
        setPadre(padre);
    }

    @Override
    protected ILayoutInnerForm<Consignatario> generarLayout(AbstractForm<Consignatario> padre, String titulo){
        return new ConsignatarioInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_CONSIGNATARIO"; }

    @Override
    public Class<Consignatario> getEntityType() { return Consignatario.class; }

    @Override
    public String getTitulo() {
        return "Consignatario";
    }
}
