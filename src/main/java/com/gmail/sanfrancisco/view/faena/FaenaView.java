package com.gmail.sanfrancisco.view.faena;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Faena;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="faena", layout = MainView.class)
@PageTitle("Lista de faenas")
@MenuIcon(VaadinIcon.SPECIALIST)
public class FaenaView extends AbstractDefaultView<Faena> {
    @Inject
    public FaenaView(AbstractList<Faena> list, AbstractPreview<Faena> preview, AbstractForm<Faena> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}