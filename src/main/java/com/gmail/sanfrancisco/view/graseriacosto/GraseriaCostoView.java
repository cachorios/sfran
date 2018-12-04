package com.gmail.sanfrancisco.view.graseriacosto;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.GraseriaCosto;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="graseriacosto", layout = MainView.class)
@PageTitle("Costos de Graserias")
@MenuIcon(VaadinIcon.SPECIALIST)
public class GraseriaCostoView extends AbstractDefaultView<GraseriaCosto> {
    @Inject
    public GraseriaCostoView(AbstractList<GraseriaCosto> list, AbstractPreview<GraseriaCosto> preview, AbstractForm<GraseriaCosto> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}