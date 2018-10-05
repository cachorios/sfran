package com.gmail.sanfrancisco.view.dte;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Dte;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="dtes", layout = MainView.class)
@PageTitle("Lista de DTEs")
@MenuIcon(VaadinIcon.SPECIALIST)
public class DteView extends AbstractDefaultView<Dte> {
    @Inject
    public DteView(AbstractList<Dte> list, AbstractPreview<Dte> preview, AbstractForm<Dte> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}