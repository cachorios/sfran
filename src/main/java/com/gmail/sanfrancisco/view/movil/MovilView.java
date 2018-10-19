package com.gmail.sanfrancisco.view.movil;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="moviles", layout = MainView.class)
@PageTitle("Lista de moviles")
@MenuIcon(VaadinIcon.SPECIALIST)
public class MovilView extends AbstractDefaultView<Vehiculo> {
    @Inject
    public MovilView(AbstractList<Vehiculo> list, AbstractPreview<Vehiculo> preview, AbstractForm<Vehiculo> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
