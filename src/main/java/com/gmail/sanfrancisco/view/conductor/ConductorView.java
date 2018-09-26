package com.gmail.sanfrancisco.view.conductor;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="conductores", layout = MainView.class)
@PageTitle("Lista de Conductores")
@MenuIcon(VaadinIcon.SPECIALIST)
public class ConductorView extends AbstractDefaultView<Conductor> {
    @Inject
    public ConductorView(AbstractList<Conductor> list, AbstractPreview<Conductor> preview, AbstractForm<Conductor> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}

