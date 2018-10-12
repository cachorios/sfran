package com.gmail.sanfrancisco.view.documento;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Documento;
import com.gmail.sanfrancisco.serviciosModelo.DocumentoService;

import javax.inject.Inject;

public class DocumentoListPresenter extends AbstractPresenterList<Documento, DocumentoService> {
    @Inject
    public DocumentoListPresenter(DocumentoService servicio, FilterablePageableDataProvider<Documento, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}