package com.gmail.sanfrancisco.view.renspa;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Renspa;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="renspa", layout = MainView.class)
@PageTitle("Lista de Numeros de DTE")
@MenuIcon(VaadinIcon.SPECIALIST)
public class RenspaView extends AbstractDefaultView<Renspa> {
    @Inject
    public RenspaView(AbstractList<Renspa> list, AbstractPreview<Renspa> preview, AbstractForm<Renspa> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}