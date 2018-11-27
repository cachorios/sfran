package com.gmail.sanfrancisco.view.graseriadetalleimpuesto;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.GraseriaDetalleImpuesto;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="graseriadetalleimpuesto", layout = MainView.class)
@PageTitle("Detalle de impuestos en graseria")
@MenuIcon(VaadinIcon.SPECIALIST)
public class GraseriaDetalleImpuestoView extends AbstractDefaultView<GraseriaDetalleImpuesto> {
    @Inject
    public GraseriaDetalleImpuestoView(AbstractList<GraseriaDetalleImpuesto> list, AbstractPreview<GraseriaDetalleImpuesto> preview, AbstractForm<GraseriaDetalleImpuesto> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
