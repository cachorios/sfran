package com.gmail.sanfrancisco.view.graseriadetalleinsumo;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleInsumo;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="graseriadetalleinsumo", layout = MainView.class)
@PageTitle("Detalle de insumos en graseria")
@MenuIcon(VaadinIcon.SPECIALIST)
public class GraseriaDetalleInsumoView extends AbstractDefaultView<GraseriaDetalleInsumo> {
    @Inject
    public GraseriaDetalleInsumoView(AbstractList<GraseriaDetalleInsumo> list, AbstractPreview<GraseriaDetalleInsumo> preview, AbstractForm<GraseriaDetalleInsumo> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
