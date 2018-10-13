package com.gmail.sanfrancisco.view.documento;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Documento;

import javax.inject.Inject;
import java.util.Arrays;

public class DocumentoList extends AbstractList<Documento> {
    @Inject
    public DocumentoList(IPresenterList<Documento> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Documento::getNombreArchivo,"Nombre de archivo","nombreArchivo", true),
                new ColumnList<>(Documento::getDescripcion,"Descripción","descripcion", true)
        ));
    }

    @Override
    public String getTagVista(){ return "Documento"; }

    @Override
    public Class<Documento> getEntityType() { return Documento.class; }

    @Override
    public String getTitulo() { return "Lista de Documentos"; }
}

