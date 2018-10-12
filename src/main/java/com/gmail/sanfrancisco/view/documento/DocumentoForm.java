package com.gmail.sanfrancisco.view.documento;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.Documento;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class DocumentoForm extends AbstractForm<Documento> {

    @Inject
    public DocumentoForm(IPresenterForm<Documento> presenter) { super(presenter); }

    @Override
    protected ILayoutInnerForm<Documento> generarLayout(AbstractForm<Documento> padre, String titulo){
        return new DocumentoInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() { return null; }

    @Override
    public String getTagVista() { return "RCV_TAG_DOCUMENTO"; }

    @Override
    public Class<Documento> getEntityType() { return Documento.class; }

    @Override
    public String getTitulo() {
        return "Documento";
    }
}