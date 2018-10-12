package com.gmail.sanfrancisco.view.documento;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Documento;
import com.gmail.sanfrancisco.serviciosModelo.DocumentoService;

import javax.inject.Inject;
import java.util.Arrays;

public class DocumentoFormPresenter extends AbstractPresenterForm<Documento, DocumentoService> {
    @Inject
    public DocumentoFormPresenter(DocumentoService servicio) { super(servicio); }
}