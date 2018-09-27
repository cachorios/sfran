package com.gmail.sanfrancisco.view.comisionista;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="comisionistas", layout = MainView.class)
@PageTitle("Lista de Comisionistas")
@MenuIcon(VaadinIcon.SPECIALIST)
public class ComisionistaView extends AbstractDefaultView<Comisionista> {
    @Inject
    public ComisionistaView(AbstractList<Comisionista> list, AbstractPreview<Comisionista> preview, AbstractForm<Comisionista> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
