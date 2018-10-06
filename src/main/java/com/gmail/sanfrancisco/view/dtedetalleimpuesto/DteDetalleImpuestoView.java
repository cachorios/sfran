package com.gmail.sanfrancisco.view.dtedetalleimpuesto;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.DteDetalleImpuesto;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="dte-impuestos", layout = MainView.class)
@PageTitle("Lista de Detalles de impuestos en DTE")
@MenuIcon(VaadinIcon.SPECIALIST)
public class DteDetalleImpuestoView extends AbstractDefaultView<DteDetalleImpuesto> {
    @Inject
    public DteDetalleImpuestoView(AbstractList<DteDetalleImpuesto> list, AbstractPreview<DteDetalleImpuesto> preview, AbstractForm<DteDetalleImpuesto> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}