package com.gmail.sanfrancisco.view.documento;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Documento;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="documentos", layout = MainView.class)
@PageTitle("Lista de Documentos")
@MenuIcon(VaadinIcon.SPECIALIST)
public class DocumentoView extends AbstractDefaultView<Documento> {
    @Inject
    public DocumentoView(AbstractList<Documento> list, AbstractPreview<Documento> preview, AbstractForm<Documento> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}