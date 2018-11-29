package com.gmail.sanfrancisco.view.graseria;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Graseria;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="graseria", layout = MainView.class)
@PageTitle("Lista Facturas  de costos de Graseria")
@MenuIcon(VaadinIcon.SPECIALIST)
public class GraseriaView extends AbstractDefaultView<Graseria> {
    @Inject
    public GraseriaView(AbstractList<Graseria> list, AbstractPreview<Graseria> preview, AbstractForm<Graseria> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}