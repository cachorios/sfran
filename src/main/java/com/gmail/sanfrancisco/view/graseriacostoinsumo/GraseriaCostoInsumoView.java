package com.gmail.sanfrancisco.view.graseriacostoinsumo;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumo;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="graseriacostoinsumo", layout = MainView.class)
@PageTitle("Detalle de insumos en graseriaCosto")
@MenuIcon(VaadinIcon.SPECIALIST)
public class GraseriaCostoInsumoView extends AbstractDefaultView<GraseriaCostoInsumo> {
    @Inject
    public GraseriaCostoInsumoView(AbstractList<GraseriaCostoInsumo> list, AbstractPreview<GraseriaCostoInsumo> preview, AbstractForm<GraseriaCostoInsumo> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
