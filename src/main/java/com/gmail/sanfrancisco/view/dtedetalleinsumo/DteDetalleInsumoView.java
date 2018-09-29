package com.gmail.sanfrancisco.view.dtedetalleinsumo;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.DteDetalleInsumo;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="detalles de insumos en DTE", layout = MainView.class)
@PageTitle("Lista de Detalles de insumos en DTE")
@MenuIcon(VaadinIcon.SPECIALIST)
public class DteDetalleInsumoView extends AbstractDefaultView<DteDetalleInsumo> {
    @Inject
    public DteDetalleInsumoView(AbstractList<DteDetalleInsumo> list, AbstractPreview<DteDetalleInsumo> preview, AbstractForm<DteDetalleInsumo> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}