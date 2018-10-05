package com.gmail.sanfrancisco.view.insumo;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="insumos", layout = MainView.class)
@PageTitle("Lista de Insumos")
@MenuIcon(VaadinIcon.SPECIALIST)
public class InsumoView extends AbstractDefaultView<Insumo> {
    @Inject
    public InsumoView(AbstractList<Insumo> list, AbstractPreview<Insumo> preview, AbstractForm<Insumo> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
