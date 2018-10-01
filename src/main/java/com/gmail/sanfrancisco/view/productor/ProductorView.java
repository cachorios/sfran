package com.gmail.sanfrancisco.view.productor;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Productor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="productores", layout = MainView.class)
@PageTitle("Lista de Productores")
@MenuIcon(VaadinIcon.SPECIALIST)
public class ProductorView extends AbstractDefaultView<Productor> {
    @Inject
    public ProductorView(AbstractList<Productor> list, AbstractPreview<Productor> preview, AbstractForm<Productor> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
