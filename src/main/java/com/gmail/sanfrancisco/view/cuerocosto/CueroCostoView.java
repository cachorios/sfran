package com.gmail.sanfrancisco.view.cuerocosto;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.CueroCosto;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="cuerocosto", layout = MainView.class)
@PageTitle("Costos de Cueros")
@MenuIcon(VaadinIcon.SPECIALIST)
public class CueroCostoView extends AbstractDefaultView<CueroCosto> {
    @Inject
    public CueroCostoView(AbstractList<CueroCosto> list, AbstractPreview<CueroCosto> preview, AbstractForm<CueroCosto> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}